package co.edu.uco.bodyhealty.entity;

import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import static co.edu.uco.bodyhealty.crosscutting.helpers.NumericHelper.ZERO;

public final class CitaEntity {
	private int id;
	private PacienteEntity paciente;
	private TurnoEntity turno;
	private ServicioEntity servicio;
	private CubiculoEntity cubiculo;
	private EstadoCitaEntity estadoCita;

	private CitaEntity(final int id) {
		setId(id);
		setPaciente(PacienteEntity.build());
		setTurno(TurnoEntity.build());
		setServicio(ServicioEntity.build());
		setCubiculo(CubiculoEntity.build());
		setEstadoCita(EstadoCitaEntity.build());
	}

	private CitaEntity(final int id, final PacienteEntity paciente, final TurnoEntity turno,
			final ServicioEntity servicio, final CubiculoEntity cubiculo, final EstadoCitaEntity estadoCita) {
		setId(id);
		setPaciente(paciente);
		setTurno(turno);
		setServicio(servicio);
		setCubiculo(cubiculo);
		setEstadoCita(estadoCita);
	}

	public static final CitaEntity build(final int id) {
		return new CitaEntity(id);
	}

	public static final CitaEntity build(final int id, final PacienteEntity paciente, final TurnoEntity turno,
			final ServicioEntity servicio, final CubiculoEntity cubiculo, final EstadoCitaEntity estadoCita) {
		return new CitaEntity(id, paciente, turno, servicio, cubiculo, estadoCita);
	}

	protected static final CitaEntity build() {
		return new CitaEntity(ZERO);
	}

	public final int getId() {
		return id;
	}

	public final PacienteEntity getPaciente() {
		return paciente;
	}

	public final TurnoEntity getTurno() {
		return turno;
	}

	public final ServicioEntity getServicio() {
		return servicio;
	}

	public final CubiculoEntity getCubiculo() {
		return cubiculo;
	}

	public final EstadoCitaEntity getEstadoCita() {
		return estadoCita;
	}

	private final void setId(final int id) {
		this.id = id;
	}

	private final void setPaciente(final PacienteEntity paciente) {
		this.paciente = ObjectHelper.getObjectHelper().getDefault(paciente, PacienteEntity.build(0));
	}

	private final void setTurno(final TurnoEntity turno) {
		this.turno = ObjectHelper.getObjectHelper().getDefault(turno, TurnoEntity.build(0));
	}

	private final void setServicio(final ServicioEntity servicio) {
		this.servicio = ObjectHelper.getObjectHelper().getDefault(servicio, ServicioEntity.build(0));
	}

	private final void setCubiculo(final CubiculoEntity cubiculo) {
		this.cubiculo = ObjectHelper.getObjectHelper().getDefault(cubiculo, CubiculoEntity.build(0));
	}

	private final void setEstadoCita(final EstadoCitaEntity estadoCita) {
		this.estadoCita = ObjectHelper.getObjectHelper().getDefault(estadoCita, EstadoCitaEntity.build(0));
	}
}