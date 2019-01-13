package api.hairstyle;


import api.hairstyle.dto.HairstyleDto;
import application.service.hairstyle.HairstyleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HairstyleJsonResourceTest {

	private static final String NAME = "Luz Clarita";
	private static final int PRICE = 15;

	private HairstyleJsonResource hairstyleJsonResource;

	@Mock
	private HairstyleService hairstyleService;
	private HairstyleDto hairstyleDto;

	private void createDto(){
		hairstyleDto = new HairstyleDto();

		hairstyleDto.setName(NAME);
		hairstyleDto.setPrice(PRICE);
	}

	@Before
	public void setUp(){
		createDto();
		hairstyleJsonResource = new HairstyleJsonResource(hairstyleService);

	}

	@Test
	public void whenCreatingANewHairStyle_thenDelagateToService()throws Exception{

		hairstyleJsonResource.create(hairstyleDto);

		verify(hairstyleService).create(hairstyleDto);
	}
}
