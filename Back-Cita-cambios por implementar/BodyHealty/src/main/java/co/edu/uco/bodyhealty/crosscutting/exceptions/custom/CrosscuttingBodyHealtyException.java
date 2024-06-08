package co.edu.uco.bodyhealty.crosscutting.exceptions.custom;

import co.edu.uco.bodyhealty.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.crosscutting.exceptions.enums.Lugar;

public final class CrosscuttingBodyHealtyException extends BodyHealtyException{
	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.CROSSCUTTING;

	public CrosscuttingBodyHealtyException(final String mensajeUsuario) {
	    super(mensajeUsuario, lugar);
	}

	public CrosscuttingBodyHealtyException(final String mensajeTecnico, final String mensajeUsuario) {
	    super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public CrosscuttingBodyHealtyException(final String mensajeTecnico, final String mensajeUsuario,
	                                       final Throwable excepcionRaiz) {
	    super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
