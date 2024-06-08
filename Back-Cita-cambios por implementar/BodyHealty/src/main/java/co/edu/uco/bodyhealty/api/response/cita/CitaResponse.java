package co.edu.uco.bodyhealty.api.response.cita;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.api.response.Response;
import co.edu.uco.bodyhealty.dto.CitaDTO;

public class CitaResponse extends Response<CitaDTO> {
	public static final CitaResponse build(final List<String> mensajes,final List<CitaDTO> datos) {
		CitaResponse instance = new CitaResponse();
		instance.setMensajes(mensajes);
		instance.setDatos(datos);
		
		return instance;
	}

	
	public static final CitaResponse build(final List<CitaDTO> datos) {
		CitaResponse instance = new CitaResponse();
		instance.setMensajes(new ArrayList<>());
		instance.setDatos(datos);
		
		return instance;
	}
	
	public static final CitaResponse build() {
		CitaResponse instance = new CitaResponse();
		instance.setMensajes(new ArrayList<>());
		instance.setDatos(new ArrayList<>());
		
		return instance;
	}
}
