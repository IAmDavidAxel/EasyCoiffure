package domain.user.password;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BasicPasswordPolicyTest {

	private static final String NOT_LONG_ENOUGH_PASSWORD = "Win";
	private static final String PASSWORD_MATCHING_PATTERN = "Wint3rIsH3re!";

	private BasicPasswordPolicy basicPasswordPolicy;

	@Before
	public void setUp(){
		basicPasswordPolicy = new BasicPasswordPolicy();
	}

	@Test
	public void whenPasswordMatchPattern_thenReturnTrue()throws Exception{

	}

	@Test
	public void whenPasswordIsLongEnough_thenReturnTrue()throws Exception{

		boolean isNotLongEnough = basicPasswordPolicy.matchLength(NOT_LONG_ENOUGH_PASSWORD);

		assertFalse(isNotLongEnough);

	}

	@Test
	public void whenPasswordMatchThePattern_thenReturnTrue()throws Exception{

		boolean isPasswordMatchingPattern = basicPasswordPolicy.matchPatterns(PASSWORD_MATCHING_PATTERN);

		assertTrue(isPasswordMatchingPattern);

	}

}