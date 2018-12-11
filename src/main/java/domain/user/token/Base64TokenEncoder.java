package domain.user.token;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64TokenEncoder implements TokenEncoder {

	private String salt;
	private String token;

	public Base64TokenEncoder() {
		this.salt = null;
		this.token = null;
	}

	@Override
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String encode(String username, String tokenValue) {

		String toEncode  = tokenValue +"."+username;
		Base64.Encoder encoder = Base64.getEncoder();

		String encodedToken = encoder.encodeToString(toEncode.getBytes(StandardCharsets.UTF_8));

		return encodedToken;
	}
}
