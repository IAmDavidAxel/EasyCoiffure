package api.hairstyle;

import api.hairstyle.dto.HairstyleDto;
import application.service.hairstyle.HairstyleService;

public class HairstyleJsonResource {

	private HairstyleService hairstyleService;

	public HairstyleJsonResource(HairstyleService hairstyleService) {

		this.hairstyleService = hairstyleService;
	}

	public void create(HairstyleDto hairstyleDto) {

		hairstyleService.create(hairstyleDto);
	}
}
