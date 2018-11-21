package api.barber;

import application.service.barber.BarberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberJsonResourceTest {

	private BarberJsonResource barberResource;
	@Mock
	private BarberService barberService;
	private BarberDto barberDto;

	@Before
	public void setUp(){
		barberResource = new BarberJsonResource(barberService);
	}

	@Test
	public void whenCreatingNewBarber_thenDelegateToBarberService()throws Exception{

		barberResource.create(barberDto);

		verify(barberService).create(barberDto);
	}

	@Test
	public void whenFindAllBarber_thenDelegatingFindingToRepo()throws Exception{

		barberResource.listAllBarbers();

		verify(barberService).findAllBarbers();
	}
}
