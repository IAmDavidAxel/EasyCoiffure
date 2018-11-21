package domain.user;

import domain.user.password.Password;
import domain.user.token.Token;

public class Credential {

	private Password password;
	private AccessLevel accessLevel;
	private Token token;

	public Credential(Password password, AccessLevel accessLevel, Token token) {
		this.password = password;

		this.accessLevel = accessLevel;
		this.token = token;
	}

	public Password getPassword() {
		return password;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public Token getToken() {
		return token;
	}
}
