package api.client;

import application.service.client.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientJsonResourceTest {

	private ClientJsonResource clientJsonResource;
	@Mock
	private ClientService clientService;
	private ClientDto clientDto;

	@Before
	public void setUp(){

		clientJsonResource = new ClientJsonResource(clientService);

	}

	@Test
	public void whenCreatingClientAccount_thenDelegateToTheService()throws Exception{

		clientJsonResource.create(clientDto);

		verify(clientService).create(clientDto);
	}

}