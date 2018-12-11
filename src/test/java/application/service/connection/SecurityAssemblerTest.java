package application.service.connection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecurityAssemblerTest {

	private static final String ACCESS_TOKEN = "token7987654";
	private static final long EXPIRES_IN = 3645L;

	private SecurityAssembler securityAssembler;

	@Before
	public void setUp(){
		securityAssembler = new SecurityAssembler();
	}

	@Test
	public void givenATokenAndExpiresDate_whenAssemblingTokenDto_thenAllDtoFieldAreEquals(){

		TokenDto tokenDto = securityAssembler.toTokenDto(ACCESS_TOKEN,EXPIRES_IN);

		assertEquals(ACCESS_TOKEN,tokenDto.getToken());
		assertEquals(EXPIRES_IN,tokenDto.getExpireIn());



	}



}