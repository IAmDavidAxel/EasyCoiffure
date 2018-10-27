package application.service.barber;

import domain.barber.Barber;
import domain.barber.BarberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import resource.barber.BarberDto;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BarberServiceTest {

	private BarberService barberService;
	@Mock
	private BarberAssembler barberAssembler;
	@Mock
	private BarberRepository barberRepository;
	private BarberDto barberDto;

	private Barber barber;

	@Before
	public void setUp(){
		barberService = new BarberService(barberService,barberAssembler);
	}

	@Test
	public void whenCreating_thenAssembleToDtoBeforeSaving()throws Exception{

		barberService.create(barberDto);

		verify(barberAssembler).assemble(barberDto);
	}

	@Test
	public void whenCreating_thenDelegateToRepositoryToSave()throws Exception{

		willReturn(barber).given(barberAssembler).assemble(barberDto);

		barberService.create(barberDto);

		verify(barberRepository).save(barber);
	}



}