package co.edu.uco.bodyhealty.business.fecade;

import java.util.List;

import co.edu.uco.bodyhealty.dto.ServicioDTO;

public interface ConsultarServiciosFachada {
	List<ServicioDTO> execute(ServicioDTO servicio);
}