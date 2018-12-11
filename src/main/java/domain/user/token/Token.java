package domain.user.token;


import domain.DateTime;
import domain.user.IllegalTokenValidationException;
import utility.ApplicationConfiguration;

public class Token {

	private DateTime createdAt;
	private String tokenValue;
	private ValidationStatus validationStatus;
	private TokenExpirationPolicy policy;

	public Token(DateTime createdAt) {

		this.createdAt = createdAt;
		policy =TokenExpirationPolicy.expirationPolicy(ApplicationConfiguration.tokenExpirationPolicy);
		tokenValue="";
	}

	public Token(String tokenValue, long tokenCreationDate) {

		this.tokenValue = tokenValue;
		createdAt = new DateTime(tokenCreationDate);
		policy = TokenExpirationPolicy.expirationPolicy(ApplicationConfiguration.tokenExpirationPolicy);
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public ValidationStatus getValidationStatus() {
		return validationStatus;
	}

	public TokenExpirationPolicy getPolicy() {
		return policy;
	}

	public void generate() {
		tokenValue = RandomAlphaNumericGenerator.generateString(ApplicationConfiguration.tokenLength);

		validationStatus =ValidationStatus.VALID;
		createdAt.setToCurrentTime();

	}


	public void verify(String tokenValue) throws IllegalTokenValidationException {

		if (!this.tokenValue.equals(tokenValue)){
			throw new IllegalTokenValidationException();
		}

	}
}
