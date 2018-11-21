package domain.user.token;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomAlphaNumericGeneratorTest {

	private static final String DEFAULT_ALPHA_NUMERIC_CHAR_SEQ = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";

	private static final int TOKEN_LENGTH = 2500;
	private RandomAlphaNumericGenerator randomAlphaNumericGenerator;

	@Before
	public void setUP(){
		randomAlphaNumericGenerator = new RandomAlphaNumericGenerator();
	}

	@Test
	public void givenSequenceDifferentThanZero_whenGenerating_thenReturnAlphaNumericSequenceDifferentFromDefaultOne(){

		String sequence = randomAlphaNumericGenerator.generateString(TOKEN_LENGTH);

		assertNotEquals(DEFAULT_ALPHA_NUMERIC_CHAR_SEQ,sequence);


	}
}