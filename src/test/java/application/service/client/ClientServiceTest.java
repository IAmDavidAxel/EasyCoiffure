package application.service.client;

import api.client.ClientDto;
import domain.user.client.Client;
import domain.user.client.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

	private ClientService clientService;

	@Mock
	private ClientRepository clientRepository;
	@Mock
	private ClientAssembler clientAssembler;
	private ClientDto clientDto;
	private Client client;

	@Before
	public void setUp(){

		clientService = new ClientService(clientAssembler,clientRepository);

	}

	@Test
	public void whenCreatingANewClient_thenDelegateConversionToTheAssembler()throws Exception{

		clientService.create(clientDto);

		verify(clientAssembler).assemble(clientDto);
	}

	@Test
	public void whenCreatingANewClient_thenDelegateSavingToTheRepo()throws Exception{
		willReturn(client).given(clientAssembler).assemble(clientDto);

		clientService.create(clientDto);

		verify(clientRepository).save(client);
	}

}