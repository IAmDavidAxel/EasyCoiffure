package domain.user;

import domain.DateTime;
import domain.user.token.Token;
import domain.user.token.TokenExpirationPolicy;
import domain.user.token.ValidationStatus;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utility.ApplicationConfiguration;

public class TokenTest {

	private static final String TOKEN_VALUE = "";

	private static final long tokenCreationDate = 20180523L;
	private static final String ANOTHER_TOKEN_VALUE = "";

	private ValidationStatus validationStatus;
	private TokenExpirationPolicy tokenExpirationPolicy;
	private Token token;
	private Token anotherToken;
	private DateTime dateTime;

	@BeforeClass
	public static void setUpConfig(){
		ApplicationConfiguration.tokenLength = 60;
		ApplicationConfiguration.tokenExpirationPolicy = "midterm";

	}
	@Before
	public void setUp(){

		token = new Token(dateTime);
		token = new Token(TOKEN_VALUE,tokenCreationDate);

	}

	@Test
	public void whenGenerating_thenStatusIsValidAndTokenValueIsAlphaNumeric(){

		token.generate();

	}

	@Test(expected =  IllegalTokenValidationException.class)
	public void whenVerifyingTheValueAndItsDifferent_thenThrowException()throws Exception{

		token.generate();

		token.verify(ANOTHER_TOKEN_VALUE);


	}




}