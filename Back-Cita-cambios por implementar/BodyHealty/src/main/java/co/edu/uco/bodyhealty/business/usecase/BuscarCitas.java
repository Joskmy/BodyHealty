package co.edu.uco.bodyhealty.business.usecase;

import java.util.List;

import co.edu.uco.bodyhealty.business.domain.CitaDomain;

public interface BuscarCitas {
	
	List<CitaDomain> ejecutar(CitaDomain cita);

}
