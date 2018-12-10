package api.connection;

import application.service.connection.AuthenticationService;
import application.service.connection.TokenDto;

public class ConnectionJsonResource {

	private AuthenticationService authenticationService;

	public ConnectionJsonResource(AuthenticationService authenticationService) {

		this.authenticationService = authenticationService;
	}

	public void login(ConnectionDto connectionDto) {

		TokenDto tokenDto = authenticationService.authenticate(connectionDto);
	}
}
