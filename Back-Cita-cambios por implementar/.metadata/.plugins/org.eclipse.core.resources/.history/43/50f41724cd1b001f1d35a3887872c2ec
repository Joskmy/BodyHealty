package co.edu.uco.bodyhealty.entity;

import static co.edu.uco.bodyhealty.crosscutting.helpers.NumericHelper.ZERO;
import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public final class TipoDocumentoEntity {
	private int id;
    private String nombre;

    private TipoDocumentoEntity(final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
    }

    private TipoDocumentoEntity(final int id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static final TipoDocumentoEntity build(final int id) {
        return new TipoDocumentoEntity(id);
    }

    public static final TipoDocumentoEntity build(final int id, final String nombre) {
        return new TipoDocumentoEntity(id, nombre);
    }

    protected static final TipoDocumentoEntity build() {
        return new TipoDocumentoEntity(ZERO);
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
