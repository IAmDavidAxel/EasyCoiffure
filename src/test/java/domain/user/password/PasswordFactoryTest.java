package domain.user.password;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.willReturn;

@RunWith(MockitoJUnitRunner.class)
public class PasswordFactoryTest {

	private static final String USER_PASSWORD = "Wint3rIsH3re!";
	private PasswordFactory passwordFactory;

	@Mock
	private PasswordPolicy passwordPolicy;

	@Before
	public void setUp(){
		passwordFactory = new PasswordFactory(passwordPolicy);
	}

	@Test
	public void whenCreatingUsingFactory_thenCreatesAPasswordObject() throws Exception{

		willReturn(true).given(passwordPolicy).isValid(USER_PASSWORD);

		Password password =  passwordFactory.create(USER_PASSWORD);

		assertNotNull(password);
	}
}
