package application.service.hairstyle;

import api.hairstyle.dto.HairstyleDto;
import domain.hairstyle.Hairstyle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HairstyleAssemblerTest {

	private static final String NAME = "Luz Clarita";
	private static final int PRICE = 15;

	private HairstyleAssembler hairstyleAssembler;
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

		hairstyleAssembler = new HairstyleAssembler();


	}

	@Test
	public void whenAssemblingANewDomainHairstyle_thenAllAttributesAreEquals(){

		Hairstyle assembledHairstyle = hairstyleAssembler.assemble(hairstyleDto);

		String nameFromAssembledObject  = assembledHairstyle.getName();
		int  priceFromAssembledObject = assembledHairstyle.getPrice();

		assertEquals(NAME,nameFromAssembledObject);
		assertEquals(PRICE,priceFromAssembledObject);
	}

	@Test
	public void whenAssemblingUIObject_thenAllAttributesAreEquals(){

		HairstyleDto assembledHairstyleDto = hairstyleAssembler.assemble(hairstyle);

		String nameFromAssembledObject = assembledHairstyleDto.getName();
		int priceFromAssembledObject = assembledHairstyleDto.getPrice();

		assertEquals(NAME,nameFromAssembledObject);
		assertEquals(PRICE,priceFromAssembledObject);
	}







}