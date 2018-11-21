package domain.user;

import domain.DateTime;
import domain.user.token.Token;
import domain.user.token.TokenExpirationPolicy;
import domain.user.token.ValidationStatus;
import org.junit.Before;
import org.junit.Test;

public class TokenTest {

	private static final String TOKEN_VALUE = "";

	private static final long tokenCreationDate = 20180523L;

	private ValidationStatus validationStatus;
	private TokenExpirationPolicy tokenExpirationPolicy;
	private Token token;
	private Token anotherToken;
	private DateTime dateTime;


	@Before
	public void setUp(){

		token = new Token(dateTime);
		token = new Token(TOKEN_VALUE,tokenCreationDate);
	}

	@Test
	public void whenGenerating_thenStatusIsValidAndTokenValueIsAlphaNumeric(){

		token.generate();

	}




}