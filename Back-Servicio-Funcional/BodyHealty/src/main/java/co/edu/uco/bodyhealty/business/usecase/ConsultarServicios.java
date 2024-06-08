package co.edu.uco.bodyhealty.business.usecase;

import java.util.List;

import co.edu.uco.bodyhealty.business.domain.ServicioDomain;

public interface ConsultarServicios {
	List<ServicioDomain> ejecutar(ServicioDomain pais);
}
