package api.client;

import application.service.client.ClientService;

public class ClientJsonResource implements ClientResource {


	private ClientService clientService;

	public ClientJsonResource(ClientService clientService) {

		this.clientService = clientService;
	}

	@Override
	public void create(ClientDto clientDto) {

		clientService.create(clientDto);

	}
}
