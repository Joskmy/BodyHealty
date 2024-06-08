package co.edu.uco.bodyhealty.business.domain;

import java.time.LocalTime;

import co.edu.uco.bodyhealty.crosscutting.helpers.DateHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;

public class TurnoDomain {
	private int id;
    private AgendaDomain agenda;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public TurnoDomain() {
        setAgenda(AgendaDomain.crear());
        setHoraInicio(DateHelper.getDefaultTime());
        setHoraFin(DateHelper.getDefaultTime());
    }

    public TurnoDomain(final int id, final AgendaDomain agenda, final LocalTime horaInicio, final LocalTime horaFin) {
        setId(id);
        setAgenda(agenda);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
    }
    
    public static final TurnoDomain crear() {
        return new TurnoDomain();
    }
    
    public static final TurnoDomain crear(final int id, final AgendaDomain agenda, final LocalTime horaInicio, final LocalTime horaFin) {
        return new TurnoDomain(id, agenda, horaInicio, horaFin);
    }

    public final int getId() {
        return id;
    }

    public final AgendaDomain getAgenda() {
        return agenda;
    }

    public final LocalTime getHoraInicio() {
        return horaInicio;
    }

    public final LocalTime getHoraFin() {
        return horaFin;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final void setAgenda(final AgendaDomain agenda) {
        this.agenda = ObjectHelper.getObjectHelper().getDefault(agenda, AgendaDomain.crear());
    }

    public final void setHoraInicio(final LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public final void setHoraFin(final LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
