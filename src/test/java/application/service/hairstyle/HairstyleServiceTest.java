package application.service.hairstyle;

import api.hairstyle.dto.HairstyleDto;
import domain.hairstyle.Hairstyle;
import domain.hairstyle.HairstyleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HairstyleServiceTest {

	private static final int PRICE = 15;
	private static final String NAME ="Luz Clarita";

	@Mock
	private HairstyleRepository hairstyleRepository;
	@Mock
	private HairstyleAssembler hairstyleAssembler;

	private HairstyleService hairstyleService;
	private HairstyleDto hairstyleDto;
	private Hairstyle hairstyle;

	private void setUpDto(){
		hairstyleDto = new HairstyleDto();

		hairstyleDto.setName(NAME);
		hairstyleDto.setPrice(PRICE);
	}

	@Before
	public void setUp(){
		setUpDto();
		hairstyle = new Hairstyle(NAME,PRICE);

		hairstyleService = new HairstyleService(hairstyleRepository,hairstyleAssembler);
	}

	@Test
	public void whenCreatingANewHairstyle_thenDelegateAssemblingToTheAssembler()throws Exception{

		hairstyleService.create(hairstyleDto);

		verify(hairstyleAssembler).assemble(hairstyleDto);

	}

	@Test
	public void whenCreatingANewHairstyle_thenDelegateSavingToTheRepo()throws Exception{

		willReturn(hairstyle).given(hairstyleAssembler).assemble(hairstyleDto);

		hairstyleService.create(hairstyleDto);

		verify(hairstyleRepository).save(hairstyle);

	}

}