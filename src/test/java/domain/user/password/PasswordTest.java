package domain.user.password;

import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.Assert.*;

public class PasswordTest {

	private static final String PLAIN_PASSWORD = "SponeBob";
	private Password password;

	@Before
	public void setUp(){
		password =new Password();
	}

	@Test
	public void givenAPassword_whenDigested_thenIsDifferentFromPlainOne()throws Exception{

		password.generateFromString(PLAIN_PASSWORD);

		String digestedPassword = password.getPasswordDigest();

		assertNotEquals(PLAIN_PASSWORD,digestedPassword);
	}

	@Test
	public void givenAPassword_whenDigested_thenRealPassword()throws Exception{

		password.generateFromString(PLAIN_PASSWORD);

		String digestedPassword = password.getPasswordDigest();

		boolean isSamePassword = BCrypt.checkpw(PLAIN_PASSWORD,digestedPassword);

		assertTrue(isSamePassword);
	}

	@Test(expected = WrongPasswordException.class)
	public void whenPasswordsAreDifferent_thenThrowException()throws Exception{

		password.generateFromString("NotGood");

		password.verify(PLAIN_PASSWORD);
	}

}
