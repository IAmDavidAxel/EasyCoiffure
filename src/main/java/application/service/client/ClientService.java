package application.service.client;

import api.client.ClientDto;
import domain.user.client.Client;
import domain.user.client.ClientRepository;

public class ClientService {
	private ClientAssembler clientAssembler;
	private ClientRepository clientRepository;

	public ClientService(ClientAssembler clientAssembler, ClientRepository clientRepository) {

		this.clientAssembler = clientAssembler;
		this.clientRepository = clientRepository;
	}

	public void create(ClientDto clientDto) {

		Client client = clientAssembler.assemble(clientDto);

		clientRepository.save(client);

	}
}
