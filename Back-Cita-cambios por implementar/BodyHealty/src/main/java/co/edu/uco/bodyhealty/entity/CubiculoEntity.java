package co.edu.uco.bodyhealty.entity;

import co.edu.uco.bodyhealty.crosscutting.helpers.NumericHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;

public final class CubiculoEntity {
	private int id;
	private TipoCubiculoEntity tipoCubiculo;
	private String nombre;

	private CubiculoEntity(final int id) {
		setId(id);
		setTipoCubiculo(TipoCubiculoEntity.build());
		setNombre(TextHelper.EMPTY);
	}

	private CubiculoEntity(final int id, final TipoCubiculoEntity tipoCubiculo, final String nombre) {
		setId(id);
		setTipoCubiculo(tipoCubiculo);
		setNombre(nombre);
	}

	public static final CubiculoEntity build(final int id) {
		return new CubiculoEntity(id);
	}

	

	public static final CubiculoEntity build(final int id, final TipoCubiculoEntity tipoCubiculo, final String nombre) {
		return new CubiculoEntity(id, tipoCubiculo, nombre);
	}
	
	protected static final CubiculoEntity build() {
		return new CubiculoEntity(NumericHelper.ZERO);
	}

	public final int getId() {
		return id;
	}

	public final TipoCubiculoEntity getTipoCubiculo() {
		return tipoCubiculo;
	}

	public final String getNombre() {
		return nombre;
	}

	private final void setId(final int id) {
		this.id = id;
	}

	private final void setTipoCubiculo(final TipoCubiculoEntity tipoCubiculo) {
		this.tipoCubiculo = ObjectHelper.getObjectHelper().getDefault(tipoCubiculo, TipoCubiculoEntity.build());
	}

	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
}