package application.service.connection;

import api.connection.ConnectionDto;
import domain.user.Credential;
import domain.user.credential.CredentialRepository;
import domain.user.token.Token;
import domain.user.token.TokenEncoder;
import domain.user.token.TokenExpirationPolicy;
import infrastructure.ObjectNotFoundException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {

	private static final String USERNAME = "BobCousy";
	private static final String PASSWORD = "Wint3IsC0ming!";
	private static final String TOKEN_VALUE = "tokenValue";
	private static final String ACCESS_TOKEN = "Z3Y5UjE2Z0FobDBNVEVNMU9qTER3QVhUM20xdkhyT2w3dDlhN21jQnA5ZTQ1N2hQUmZ5bG85anZJbHJ6LlNvbWVVc2VybmFtZQ";
	private static final TokenExpirationPolicy  EXPIRATION_POLICY= TokenExpirationPolicy.MID_TERM;

	private static final long EXPIRES_IN = EXPIRATION_POLICY.expiresIn();

	private AuthenticationService authenticationService;

	@Mock
	private TokenEncoder tokenEncoder;
	@Mock
	private CredentialRepository credentialRepository;
	@Mock
	private SecurityAssembler securityAssembler;
	private ConnectionDto connectionDto;
	@Mock
	private Credential credential;
	@Mock
	private Token updatedToken;
	@Mock
	private Token token;

	private void setUpDto(){
		connectionDto =new ConnectionDto(USERNAME,PASSWORD);
	}

	@Before
	public void setUp() throws Exception{
		setUpDto();

		authenticationService = new AuthenticationService(credentialRepository,tokenEncoder,securityAssembler);

		willReturn(credential).given(credentialRepository).findByUsername(USERNAME);

		willReturn(TOKEN_VALUE).given(updatedToken).getTokenValue();
		willReturn(token).given(credential).generateToken();
		willReturn(TOKEN_VALUE).given(tokenEncoder).getToken();
		willReturn(USERNAME).given(tokenEncoder).getSalt();
		willReturn(TOKEN_VALUE).given(token).getTokenValue();
		willReturn(TokenExpirationPolicy.MID_TERM).given(token).getPolicy();
	}

	@Test
	public void whenLoggingIn_DelegateFindingOfCredentialToTheRepo()throws Exception{


		authenticationService.authenticate(connectionDto);

		verify(credentialRepository).findByUsername(USERNAME);
	}

	@Test(expected = NotAuthenticatedServiceException.class)
	public void whenUserNotFound_thenThrowException()throws Exception{
		 willThrow(ObjectNotFoundException.class).given(credentialRepository).findByUsername(USERNAME);

		 authenticationService.authenticate(connectionDto);
	}

	@Test
	public void whenloggingIn_thenVerifyPassword()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(credential).verifyPassword(PASSWORD);
	}

	@Test
	public void whenLogginIn_thenGenerateNewTokenWithDelegatedToken()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(credential).generateToken();
	}

	@Test
	public void whenLoggingIn_thenDelegateCredentialSavingToTheRepo()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(credentialRepository).save(credential,USERNAME);
	}

	@Ignore
	@Test
	public void whenLoggingIn_thenDelagateEncodingToTheEncoder()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(tokenEncoder).encode(USERNAME,TOKEN_VALUE);
	}

	@Ignore
	@Test
	public void whenLoggingInSucceeded_thenReturnTokenInformationViaAssembler()throws Exception{

		authenticationService.authenticate(connectionDto);

		verify(securityAssembler).toTokenDto(ACCESS_TOKEN,EXPIRES_IN);
	}
}