package co.edu.uco.bodyhealty.dto;

import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public final class TipoCubiculoDTO {
	private int id;
	private String nombre;

	public TipoCubiculoDTO() {
		setNombre(TextHelper.EMPTY);
	}

	public TipoCubiculoDTO(final int id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoCubiculoDTO build() {
		return new TipoCubiculoDTO();
	}
	

	public final int getId() {
		return id;
	}

	public final TipoCubiculoDTO setId(final int id) {
		this.id = id;
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoCubiculoDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
}
