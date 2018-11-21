package domain.user;

import domain.user.password.Password;
import domain.user.token.Token;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CredentialFactoryTest {

	private CredentialFactory credentialFactory;

	private Credential credential;
	private  AccessLevel accessLevel;
	private Token token;
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
