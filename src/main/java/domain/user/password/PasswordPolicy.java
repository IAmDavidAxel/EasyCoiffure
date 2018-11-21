package domain.user.password;

public interface PasswordPolicy {

	boolean matchLength(String notLongEnoughPassword);

	boolean matchPatterns(String password);
}
