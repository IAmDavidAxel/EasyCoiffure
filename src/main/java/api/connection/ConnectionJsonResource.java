package api.connection;

import application.service.connection.AuthenticationService;
import application.service.connection.TokenDto;
import application.service.exception.ServiceException;

public class ConnectionJsonResource implements ConnectionResource {

	private AuthenticationService authenticationService;

	public ConnectionJsonResource(AuthenticationService authenticationService) {

		this.authenticationService = authenticationService;
	}

	@Override
	public void login(ConnectionDto connectionDto) throws ServiceException {

		TokenDto tokenDto = authenticationService.authenticate(connectionDto);
	}

	@Override
	public void logout(ConnectionDto connectionDto) throws ServiceException {

		authenticationService.logout(connectionDto);

	}
}
