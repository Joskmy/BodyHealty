package co.edu.uco.bodyhealty.entity;

import java.time.LocalTime;
import static co.edu.uco.bodyhealty.crosscutting.helpers.NumericHelper.ZERO;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;

public final class TurnoEntity {
	private int id;
	private AgendaEntity agenda;
	private LocalTime horaInicio;
	private LocalTime horaFin;

	private TurnoEntity(final int id) {
		setId(id);
		setAgenda(AgendaEntity.build());
		setHoraInicio(LocalTime.MIN);
		setHoraFin(LocalTime.MIN);
	}

	private TurnoEntity(final int id, final AgendaEntity agenda, final LocalTime horaInicio, final LocalTime horaFin) {
		setId(id);
		setAgenda(agenda);
		setHoraInicio(horaInicio);
		setHoraFin(horaFin);
	}

	public static final TurnoEntity build(final int id) {
		return new TurnoEntity(id);
	}

	public static final TurnoEntity build(final int id, final AgendaEntity agenda, final LocalTime horaInicio,
			final LocalTime horaFin) {
		return new TurnoEntity(id, agenda, horaInicio, horaFin);
	}
	
	protected static final TurnoEntity build() {
		return new TurnoEntity(ZERO);
	}

	public final int getId() {
		return id;
	}

	public final AgendaEntity getAgenda() {
		return agenda;
	}

	public final LocalTime getHoraInicio() {
		return horaInicio;
	}

	public final LocalTime getHoraFin() {
		return horaFin;
	}

	private final void setId(final int id) {
		this.id = id;
	}

	private final void setAgenda(final AgendaEntity agenda) {
		this.agenda = ObjectHelper.getObjectHelper().getDefault(agenda, AgendaEntity.build(0));
	}

	private final void setHoraInicio(final LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	private final void setHoraFin(final LocalTime horaFin) {
		this.horaFin = horaFin;
	}
}
