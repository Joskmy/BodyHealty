package co.edu.uco.bodyhealty.dto;

import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public final class CubiculoDTO {
	private int id;
    private TipoCubiculoDTO tipoCubiculo;
    private String nombre;

    public CubiculoDTO() {
        setTipoCubiculo(TipoCubiculoDTO.build());
        setNombre(TextHelper.EMPTY);
    }

    public CubiculoDTO(final int identificador, final TipoCubiculoDTO tipoCubiculo, final String nombre) {
    	setId(identificador);
        setTipoCubiculo(tipoCubiculo);
        setNombre(nombre);
    }

    public static final CubiculoDTO build() {
        return new CubiculoDTO();
    }

    public final int getId() {
        return id;
    }

    public final TipoCubiculoDTO getTipoCubiculo() {
        return tipoCubiculo;
    }

    public final String getNombre() {
        return nombre;
    }

    public final CubiculoDTO setId(final int id) {
        this.id = id;
        return this;
    }

    public final CubiculoDTO setTipoCubiculo(final TipoCubiculoDTO tipoCubiculo) {
        this.tipoCubiculo = ObjectHelper.getObjectHelper().getDefault(tipoCubiculo, TipoCubiculoDTO.build());
        return this;
    }

    public final CubiculoDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}