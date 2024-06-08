package co.edu.uco.bodyhealty.entity;

import static co.edu.uco.bodyhealty.crosscutting.helpers.NumericHelper.ZERO;
import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public final class TipoCubiculoEntity {
	private int id;
    private String nombre;

    private TipoCubiculoEntity(final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
    }

    private TipoCubiculoEntity(final int id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static final TipoCubiculoEntity build(final int id) {
        return new TipoCubiculoEntity(id);
    }

    public static final TipoCubiculoEntity build(final int id, final String nombre) {
        return new TipoCubiculoEntity(id, nombre);
    }

    protected static final TipoCubiculoEntity build() {
        return new TipoCubiculoEntity(ZERO);
    }

    private final void setId(final int id) {
        this.id = id;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public final int getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }
}
