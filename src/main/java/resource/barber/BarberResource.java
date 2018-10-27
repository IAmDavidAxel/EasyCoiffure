package resource.barber;

import application.service.barber.BarberService;
import resource.barber.BarberDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/barber")
public class BarberResource {
	private BarberService barberService;

	public BarberResource(BarberService barberService) {

		this.barberService = barberService;
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(BarberDto barberDto) {

		barberService.create(barberDto);
	}
}
