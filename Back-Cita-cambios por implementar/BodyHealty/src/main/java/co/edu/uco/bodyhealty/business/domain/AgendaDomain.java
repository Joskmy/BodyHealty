package co.edu.uco.bodyhealty.business.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import co.edu.uco.bodyhealty.crosscutting.helpers.DateHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;

public class AgendaDomain {
	private int id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private PersonalDomain personal;

    public AgendaDomain() {
        setFecha(DateHelper.getDefaultDate());
        setHoraInicio(DateHelper.getDefaultTime());
        setHoraFin(DateHelper.getDefaultTime());
        setPersonal(PersonalDomain.crear());
    }

    public AgendaDomain(final int id, final LocalDate fecha, final LocalTime horaInicio, final LocalTime horaFin, final PersonalDomain personal) {
        setId(id);
        setFecha(fecha);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
        setPersonal(personal);
    }
    
    public static final AgendaDomain crear() {
        return new AgendaDomain();
    }
    
    public static final AgendaDomain crear(final int id, final LocalDate fecha, final LocalTime horaInicio, final LocalTime horaFin, final PersonalDomain personal) {
        return new AgendaDomain(id, fecha, horaInicio, horaFin, personal);
    }

    public final int getId() {
        return id;
    }

    public final LocalDate getFecha() {
        return fecha;
    }

    public final LocalTime getHoraInicio() {
        return horaInicio;
    }

    public final LocalTime getHoraFin() {
        return horaFin;
    }

    public final PersonalDomain getPersonal() {
        return personal;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final void setFecha(final LocalDate fecha) {
        this.fecha = fecha;
    }

    public final void setHoraInicio(final LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public final void setHoraFin(final LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public final void setPersonal(final PersonalDomain personal) {
        this.personal = ObjectHelper.getObjectHelper().getDefault(personal, PersonalDomain.crear());
    }
}
