package resource.barber;

import application.service.barber.BarberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberResourceTest {

	private BarberResource barberResource;
	@Mock
	private BarberService barberService;
	private BarberDto barberDto;

	@Before
	public void setUp(){
		barberResource = new BarberResource(barberService);
	}

	@Test
	public void whenCreatingNewBarber_thenDelegateToBarberService()throws Exception{

		barberResource.create(barberDto);

		verify(barberService).create(barberDto);
	}
}
