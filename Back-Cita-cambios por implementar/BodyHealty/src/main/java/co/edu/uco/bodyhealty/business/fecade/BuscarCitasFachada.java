package co.edu.uco.bodyhealty.business.fecade;

import java.util.List;

import co.edu.uco.bodyhealty.dto.CitaDTO;

public interface BuscarCitasFachada {
	List<CitaDTO> ejecutar(CitaDTO cita);

}