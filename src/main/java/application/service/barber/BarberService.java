package application.service.barber;

import domain.barber.Barber;
import resource.barber.BarberDto;

public class BarberService {

	private BarberService barberService;
	private BarberAssembler barberAssembler;

	public BarberService(BarberService barberService, BarberAssembler barberAssembler) {
		this.barberService = barberService;
		this.barberAssembler = barberAssembler;
	}

	public void create(BarberDto barberDto) {

		Barber barber = barberAssembler.assemble(barberDto);
	}
}
