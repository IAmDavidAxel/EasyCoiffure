package domain.user.token;

import org.junit.Before;
import org.junit.Test;
import utility.ApplicationConfiguration;

import static org.junit.Assert.assertNotNull;

public class TokenFactoryTest {

	private static final String MIDTERM_EXPIRATION = "midterm";
	private TokenFactory tokenFactory;

	@Before
	public void setUp(){

		tokenFactory = new TokenFactory();
	}

	@Test
	public void whenCreatingToken_thenTheTokenIsNotNull(){
		ApplicationConfiguration.tokenExpirationPolicy = MIDTERM_EXPIRATION;

		Token token = tokenFactory.create();

		assertNotNull(token);
	}
}
