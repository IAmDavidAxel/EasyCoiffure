package domain.user;

import domain.user.password.Password;
import domain.user.password.WrongPasswordException;
import domain.user.token.Token;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.willThrow;

public class CredentialFactoryTest {

	private static final String PLAIN_PASSWORD = "Bobo";
	private CredentialFactory credentialFactory;

	private Credential credential;
	@Mock
	private  AccessLevel accessLevel;
	@Mock
	private Token token;
	@Mock
	private Password password;

	@Before
	public void setUp(){

		credentialFactory = new CredentialFactory();
		credential = new Credential(password,accessLevel,token);

	}

	@Test
	public void whenCreatingACredential_thenAccessLevelIsCorrect(){

		Credential credential = credentialFactory.create(password,AccessLevel.CLIENT,token);

		assertEquals(credential.getAccessLevel().toString(),AccessLevel.CLIENT.toString());
	}




}
