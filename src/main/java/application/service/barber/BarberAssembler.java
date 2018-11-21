package application.service.barber;

import domain.user.barber.Barber;
import api.barber.BarberDto;

import java.util.List;

public class BarberAssembler {

	public Barber assemble(BarberDto barberDto) {

		String name = barberDto.getName();
		String lastName = barberDto.getLastName();
		String address = barberDto.getAddress();
		String username = barberDto.getUsername();
		String password = barberDto.getPassword();


		return new Barber(name,lastName,password,address,username);
	}

	public List<BarberDto> assemble(List<Barber> barbers) {
		return null;
	}
}
