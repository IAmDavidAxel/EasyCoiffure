package domain.user.token;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Base64TokenEncoderTest {

	private static final String USERNAME = "Frasier";
	private static final String TOKEN_VALUE = "token7854-qs787";
	private Base64TokenEncoder base64TokenEncoder;

	@Before
	public void setUp(){
		base64TokenEncoder = new Base64TokenEncoder();
	}

	@Test
	public void whenEncodingTheToken_thenValueIsDifferentThanTheRealToken()throws Exception{

	String encodedString =	base64TokenEncoder.encode(USERNAME,TOKEN_VALUE);

	assertNotEquals(encodedString,TOKEN_VALUE);

	}

}