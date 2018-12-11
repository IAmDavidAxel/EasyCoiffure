package domain.user;

import domain.user.password.Password;
import domain.user.password.WrongPasswordException;
import domain.user.token.Token;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willThrow;

@RunWith(MockitoJUnitRunner.class)
public class CredentialTest {

	private static final String PLAIN_PASSWORD = "Wint3rIsC0ming**";
	private Credential credential;
	@Mock
	private Password password;
	@Mock
	private Token token;

	@Before
	public void setUp(){

		credential = new Credential(password,AccessLevel.CLIENT,token);
	}

	@Test(expected = WrongPasswordException.class)
	public void whenPasswordAreMismatched_thenThrowsException()throws Exception{

		willThrow(WrongPasswordException.class).given(password).verify(PLAIN_PASSWORD);

		credential.verifyPassword(PLAIN_PASSWORD);

	}



}