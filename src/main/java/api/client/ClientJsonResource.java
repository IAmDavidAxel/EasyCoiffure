package api.client;

import application.service.client.ClientService;
import application.service.exception.ServiceException;

public class ClientJsonResource implements ClientResource {


	private ClientService clientService;

	public ClientJsonResource(ClientService clientService) {

		this.clientService = clientService;
	}

	@Override
	public void create(ClientDto clientDto) throws ServiceException {

		clientService.create(clientDto);

	}
}
