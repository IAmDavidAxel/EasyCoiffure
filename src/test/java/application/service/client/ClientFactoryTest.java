package application.service.client;

import api.client.ClientDto;
import domain.user.*;
import domain.user.client.Client;
import domain.user.password.Password;
import domain.user.password.PasswordFactory;
import domain.user.token.Token;
import domain.user.token.TokenFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import utility.ApplicationConfiguration;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class ClientFactoryTest {

	private static final String NAME ="karim";
	private static final String LAST_NAME ="Benzema";
	private static final String CELL_PHONE = "581-777-8725";
	private static final String EMAIL ="d@bobo.fr";
	private static final String USERNAME = "bobLeponge";
	private static final String PASSWORD = "noboko";
	private static final String ADRESS = "2200";

	private ClientFactory clientFactory;
	private ClientDto clientDto;
	private Client client;

	@Mock
	private UserProfileFactory userProfileFactory;
	@Mock
	private CredentialFactory credentialFactory;
	@Mock
	private TokenFactory tokenFactory;
	@Mock
	private UserProfile userProfile;
	@Mock
	private Credential credential;
	@Mock
	private Password password;
	@Mock
	private Token token;
	@Mock
	private PasswordFactory passwordFactory;

	private void setUpDto(){
		clientDto = new ClientDto();

		clientDto.setName(NAME);
		clientDto.setLastName(LAST_NAME);
		clientDto.setCellPhone(CELL_PHONE);
		clientDto.setEmail(EMAIL);
		clientDto.setUsername(USERNAME);
		clientDto.setPassword(PASSWORD);
	}

	@Before
	public void setUp() throws Exception{

		willReturn(password).given(passwordFactory).create(PASSWORD);

		setUpDto();
		clientFactory = new ClientFactory(credentialFactory,userProfileFactory,tokenFactory,passwordFactory);

		ApplicationConfiguration.tokenExpirationPolicy = "midterm";

		client = new Client(userProfile,credential,EMAIL);
	}

	@Test
	public void whenAssemblingForDomain_thenTheValuesAreEquals() throws Exception{

		willReturn(token).given(tokenFactory).create();

		willReturn(credential).given(credentialFactory).create(password, AccessLevel.CLIENT,token);
		willReturn(userProfile).given(userProfileFactory).create(NAME,LAST_NAME,USERNAME,ADRESS,CELL_PHONE);



		Client assembledClient = clientFactory.create(clientDto);


		assertEquals(assembledClient.getEmail(),EMAIL);


	}

	@Test
	public void whenAssemblingForUI_thenTheValuesAreEquals() throws Exception{

		ClientDto assembledDto = clientFactory.create(client);
	}



}