package co.edu.uco.bodyhealty.business.domain;

import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public class TipoCubiculoDomain {
	private int id;
	private String nombre;

	public TipoCubiculoDomain() {
		setNombre(TextHelper.EMPTY);
	}

	public TipoCubiculoDomain(final int id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public static final TipoCubiculoDomain crear() {
		return new TipoCubiculoDomain();
	}
	public static final TipoCubiculoDomain crear(final int id, final String nombre) {
		return new TipoCubiculoDomain(id, nombre);
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
