package co.edu.uco.bodyhealty.dto;

import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public final class EstadoCitaDTO {
	private int id;
    private String estado;

    public EstadoCitaDTO() {
        setEstado(TextHelper.EMPTY);
    }

    public EstadoCitaDTO(final int id, final String estado) {
        setId(id);
        setEstado(estado);
    }

    public static final EstadoCitaDTO build() {
        return new EstadoCitaDTO();
    }

    public final int getId() {
        return id;
    }

    public final String getEstado() {
        return estado;
    }

    public final EstadoCitaDTO setId(final int id) {
        this.id = id;
        return this;
    }

    public final EstadoCitaDTO setEstado(final String estado) {
        this.estado = TextHelper.applyTrim(estado);
        return this;
    }
}