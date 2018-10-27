package application.service.barber;

import domain.barber.Barber;
import resource.barber.BarberDto;

public class BarberAssembler {

	public Barber assemble(BarberDto barberDto) {

		String name = barberDto.getName();
		String lastName = barberDto.getLastName();
		String address = barberDto.getAddress();
		String username = barberDto.getUsername();
		String password = barberDto.getPassword();


		return new Barber(name,lastName,password,address,username);
	}
}
