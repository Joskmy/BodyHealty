package co.edu.uco.bodyhealty.crosscutting.exceptions.custom;

import co.edu.uco.bodyhealty.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.crosscutting.exceptions.enums.Lugar;

public final class InitializerBodyHealtyException extends BodyHealtyException {
	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.INITIALIZER;

	public InitializerBodyHealtyException(final String mensajeUsuario) {
	    super(mensajeUsuario, lugar);
	}

	public InitializerBodyHealtyException(final String mensajeTecnico, final String mensajeUsuario) {
	    super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public InitializerBodyHealtyException(final String mensajeTecnico, final String mensajeUsuario,
	        final Throwable excepcionRaiz) {
	    super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}

}
