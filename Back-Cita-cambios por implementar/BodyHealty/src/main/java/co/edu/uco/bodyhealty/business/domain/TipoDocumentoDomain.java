package co.edu.uco.bodyhealty.business.domain;

import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public class TipoDocumentoDomain {
	private int id;
	private String nombre;

	public TipoDocumentoDomain() {
		setNombre(TextHelper.EMPTY);
	}

	public TipoDocumentoDomain(final int id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static final TipoDocumentoDomain crear() {
		return new TipoDocumentoDomain();
	}
	public static final TipoDocumentoDomain crear(final int id, final String nombre) {
		return new TipoDocumentoDomain(id, nombre);
	}

	public final int getId() {
		return id;
	}

	public final void setId(final int id) {
		this.id = id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
}
