package co.edu.uco.bodyhealty.business.domain;

import co.edu.uco.bodyhealty.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public class ServicioDomain {
	private int id;
	private String nombreServicio;
	private int duracionEstimada;
	private String descripcion;

	public ServicioDomain() {
		setNombreServicio(TextHelper.EMPTY);
		setDuracionEstimada(NumericHelper.ZERO);
		setDescripcion(TextHelper.EMPTY);
	}

	public ServicioDomain(final int id, final String nombreServicio, final int duracionEstimada,
			final String descripcion) {
		setId(id);
		setNombreServicio(nombreServicio);
		setDuracionEstimada(duracionEstimada);
		setDescripcion(descripcion);
	}

	public static final ServicioDomain crear() {
		return new ServicioDomain();
	}
	
	public static final ServicioDomain crear(final int id, final String nombreServicio, final int duracionEstimada,
			final String descripcion) {
		return new ServicioDomain(id, nombreServicio, duracionEstimada, descripcion);
	}

	public final int getId() {
		return id;
	}

	public final String getNombreServicio() {
		return nombreServicio;
	}

	public final int getDuracionEstimada() {
		return duracionEstimada;
	}

	public final String getDescripcion() {
		return descripcion;
	}

	public final void setId(final int id) {
		this.id = id;
	}

	public final void setNombreServicio(final String nombreServicio) {
		this.nombreServicio = TextHelper.applyTrim(nombreServicio).toLowerCase();
	}

	public final void setDuracionEstimada(final int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}

	public final void setDescripcion(final String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion).toLowerCase();
	}
}
