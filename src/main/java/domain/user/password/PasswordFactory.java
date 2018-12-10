package domain.user.password;

public class PasswordFactory {
	private PasswordPolicy passwordPolicy;

	public PasswordFactory(PasswordPolicy passwordPolicy) {

		this.passwordPolicy = passwordPolicy;
	}

	public Password create(String userPassword) throws IllegalPasswordFormatException {

		if(passwordPolicy.isValid(userPassword)){
			return new Password(userPassword);
		}
		else
			throw  new IllegalPasswordFormatException();
	}
}
