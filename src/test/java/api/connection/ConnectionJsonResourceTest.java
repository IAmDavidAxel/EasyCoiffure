package api.connection;

import application.service.connection.AuthenticationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionJsonResourceTest {

	private ConnectionJsonResource connectionJsonResource;

	@Mock
	private AuthenticationService authenticationService;
	private ConnectionDto connectionDto;

	@Before
	public void setUp(){
		connectionJsonResource = new ConnectionJsonResource(authenticationService);
	}


	@Test
	public void whenLogginIn_thenAuthenticationServiceIsDelagatedOperations()throws Exception{

		connectionJsonResource.login(connectionDto);

		verify(authenticationService).authenticate(connectionDto);

	}
}
