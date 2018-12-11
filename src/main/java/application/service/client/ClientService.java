package application.service.client;

import api.client.ClientDto;
import application.service.exception.ServiceException;
import domain.user.client.Client;
import domain.user.client.ClientRepository;
import domain.user.password.IllegalPasswordFormatException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientService {
	private ClientFactory clientFactory;
	private ClientRepository clientRepository;

	public ClientService(ClientFactory clientFactory, ClientRepository clientRepository) {

		this.clientFactory = clientFactory;
		this.clientRepository = clientRepository;
	}

	public void create(ClientDto clientDto)  throws ServiceException {

		Client client = createClient(clientDto);

		clientRepository.save(client);

	}

	private Client createClient(ClientDto clientDto) throws ServiceException{

		try {
			return clientFactory.create(clientDto);
		} catch (IllegalPasswordFormatException |InvalidUserNameException e){
			Logger.getGlobal().log(Level.SEVERE,e.getMessage());
			throw  new EntityCreationServiceException(e);
		}

	}
}
