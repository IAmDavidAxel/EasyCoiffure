package domain.user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserProfileFactoryTest {

	private static final String A_NAME = "Beckham";
	private static final String LAST_NAME = "David";
	private static final String USERNAME = "Legend";
	private static final String ADDRESS = "Address";
	private static final String CELLPHONE = "5817778725";
	private UserProfileFactory userProfileFactory;
	private UserProfile userProfile;

	@Before
	public void setUp(){

		userProfile = new UserProfile(A_NAME,LAST_NAME,USERNAME,ADDRESS,CELLPHONE);

		userProfileFactory = new UserProfileFactory();
	}

	@Test
	public void whenCreatingANewProfile_thenItsInstanceOfUserProfile(){
	UserProfile userProfileFromFactory  =	userProfileFactory.create(A_NAME,LAST_NAME,USERNAME,ADDRESS,CELLPHONE);

	assertTrue(userProfileFromFactory != null);

	assertEquals(userProfileFromFactory.getName(),A_NAME);


	}
}
