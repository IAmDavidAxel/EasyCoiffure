package application.service.barber;

import domain.user.barber.Barber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import api.barber.BarberDto;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BarberAssemblerTest {

	private static final String A_NAME = "Fatou";
	private static final String AN_ADDRESS = "2200 chemin marron";
	private static final String A_LAST_NAME = "Traore";
	private static final String A_PASSWORD = "caca";
	private static final String AN_USERNAME = "uu";
	@Mock
	private BarberAssembler barberAssembler;
	private BarberDto barberDto;

	private void setUpDto(){
		barberDto = new BarberDto();

		barberDto.setName(A_NAME);
		barberDto.setAddress(AN_ADDRESS);
		barberDto.setLastName(A_LAST_NAME);
		barberDto.setPassword(A_PASSWORD);
		barberDto.setUsername(AN_USERNAME);
	}

	@Before
	public void setUp(){
		setUpDto();
		barberAssembler =  new BarberAssembler();

	}

	@Test
	public void whenAssemblingADtoObject_thenReturnANewDomainObject()throws Exception{

		Barber barber = barberAssembler.assemble(barberDto);

		assertEquals(barber.getName(),barberDto.getName());
		assertEquals(barber.getLastName(),barberDto.getLastName());
		assertEquals(barber.getPassword(),barberDto.getPassword());
		assertEquals(barber.getAddress(),barberDto.getAddress());
		assertEquals(barber.getUsername(),barberDto.getUsername());
	}

}