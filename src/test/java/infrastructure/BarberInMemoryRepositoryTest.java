package infrastructure;

import domain.user.barber.Barber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BarberInMemoryRepositoryTest {

	private static final String NAME = "da";
	private static final String USERNAME ="po";
	private static final String ADDRESS ="2250";
	private static final String PASSWORD ="popo";
	private static final String LAST_NAME = "lolo";

	private BarberInMemoryRepository barberInMemoryRepository;

	private Barber barber;

	@Before
	public void setUp(){
		barber = new Barber(NAME,LAST_NAME,PASSWORD,ADDRESS,USERNAME);
		barberInMemoryRepository = new BarberInMemoryRepository();
	}

	@Test
	public void whenABarberIsSaved_thenTheSizeOfTheDatabaseGrows()throws Exception {

		barberInMemoryRepository.save(barber.getName(),barber);

		assertEquals(barberInMemoryRepository.size(),1);

	}
}
