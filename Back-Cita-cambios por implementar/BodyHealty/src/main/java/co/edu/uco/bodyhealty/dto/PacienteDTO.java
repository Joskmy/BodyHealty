package co.edu.uco.bodyhealty.dto;

import co.edu.uco.bodyhealty.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public final class PacienteDTO {
	private int id;
	private TipoDocumentoDTO tipoId;
	private int numeroDocumento;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String correoElectronico;
	private String telefono;
	private String cuenta;
	private String contrasenia;

	public PacienteDTO() {
		setTipoId(TipoDocumentoDTO.build());
		setNumeroDocumento(NumericHelper.ZERO);
		setPrimerNombre(TextHelper.EMPTY);
		setSegundoNombre(TextHelper.EMPTY);
		setPrimerApellido(TextHelper.EMPTY);
		setSegundoApellido(TextHelper.EMPTY);
		setCorreoElectronico(TextHelper.EMPTY);
		setTelefono(TextHelper.EMPTY);
		setCuenta(TextHelper.EMPTY);
		setContrasenia(TextHelper.EMPTY);
	}

	public PacienteDTO(final int id, final TipoDocumentoDTO tipoId, final int numeroDocumento, final String primerNombre,
			final String segundoNombre, final String primerApellido, final String segundoApellido,
			final String correoElectronico, final String telefono, final String cuenta, final String contrasenia) {
		setId(id);
		setTipoId(tipoId);
		setNumeroDocumento(numeroDocumento);
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		setCorreoElectronico(correoElectronico);
		setTelefono(telefono);
		setCuenta(cuenta);
		setContrasenia(contrasenia);
	}
	
	public static final PacienteDTO build() {
		return new PacienteDTO();
	}

	public final int getId() {
		return id;
	}

	public final TipoDocumentoDTO getTipoId() {
		return tipoId;
	}

	public final int getNumeroDocumento() {
		return numeroDocumento;
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final String getTelefono() {
		return telefono;
	}

	public final String getCuenta() {
		return cuenta;
	}

	public final String getContrasenia() {
		return contrasenia;
	}

	public final PacienteDTO setId(final int id) {
		this.id = id;
		return this;
	}

	public final PacienteDTO setTipoId(final TipoDocumentoDTO tipoId) {
		this.tipoId = ObjectHelper.getObjectHelper().getDefault(tipoId, TipoDocumentoDTO.build());
		return this;
	}

	public final PacienteDTO setNumeroDocumento(final int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
		return this;
	}

	public final PacienteDTO setPrimerNombre(final String primerNombre) {
		this.primerNombre = TextHelper.applyTrim(primerNombre);
		return this;
	}

	public final PacienteDTO setSegundoNombre(final String segundoNombre) {
	    this.segundoNombre = TextHelper.applyTrim(segundoNombre);
	    return this;
	}

	public final PacienteDTO setPrimerApellido(final String primerApellido) {
	    this.primerApellido = TextHelper.applyTrim(primerApellido);
	    return this;
	}

	public final PacienteDTO setSegundoApellido(final String segundoApellido) {
	    this.segundoApellido = TextHelper.applyTrim(segundoApellido);
	    return this;
	}

	public final PacienteDTO setCorreoElectronico(final String correoElectronico) {
	    this.correoElectronico = TextHelper.applyTrim(correoElectronico);
	    return this;
	}

	public final PacienteDTO setTelefono(final String telefono) {
	    this.telefono = TextHelper.applyTrim(telefono);
	    return this;
	}

	public final PacienteDTO setCuenta(final String cuenta) {
	    this.cuenta = TextHelper.applyTrim(cuenta);
	    return this;
	}

	public final PacienteDTO setContrasenia(final String contrasenia) {
	    this.contrasenia = TextHelper.applyTrim(contrasenia);
	    return this;
	}

}