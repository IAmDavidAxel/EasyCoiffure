package application.service.barber;

import domain.user.barber.Barber;
import domain.user.barber.BarberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import api.barber.BarberDto;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

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
	private List<Barber> barbers;

	@Mock
	private Barber barber;

	@Before
	public void setUp(){

		barbers = new ArrayList<>();

		willReturn(barber).given(barberAssembler).assemble(barberDto);
		willReturn("bob").given(barber).getName();

		barberService = new BarberService(barberRepository,barberAssembler);
	}

	@Test
	public void whenCreating_thenAssembleToDtoBeforeSaving()throws Exception{

		barberService.create(barberDto);

		verify(barberAssembler).assemble(barberDto);
	}

	@Test
	public void whenCreating_thenDelegateToRepositoryToSave()throws Exception{

		barberService.create(barberDto);

		verify(barberRepository).save(barber.getName(),barber);
	}

	@Test
	public void whenFindingAllBarbers_thenDelegatingResearchingToTheRepo()throws Exception{


		barberService.findAllBarbers();

		verify(barberRepository).findAll();
	}

	@Test
	public void whenFindingAllBarbers_thenDelegatesAssemblyToTheAssembler()throws Exception{

		willReturn(barbers).given(barberRepository).findAll();

		barberService.findAllBarbers();

		verify(barberAssembler).assemble(barbers);
	}


}