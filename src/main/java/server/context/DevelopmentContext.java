package server.context;

import api.barber.BarberJsonResource;
import domain.user.barber.BarberRepository;
import infrastructure.BarberInMemoryRepository;
import server.context.barberContext.BarberResourceContext;
import utility.ServiceLocator;

public class DevelopmentContext extends Context{


	@Override
	public void registerService() {

		BarberInMemoryRepository barberRepository = new BarberInMemoryRepository();

		ServiceLocator.INSTANCE.register(BarberRepository.class,barberRepository);

	}

	@Override
	public void initialiseService() {

		BarberJsonResource barberResource = BarberResourceContext.create();

		this.resourceContext.add(barberResource);

	}
}
