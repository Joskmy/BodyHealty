package co.edu.uco.bodyhealty.dto;


import java.time.LocalDate;
import java.time.LocalTime;

import co.edu.uco.bodyhealty.crosscutting.helpers.DateHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;

public final class AgendaDTO {
	private int id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private PersonalDTO personal;

    public AgendaDTO() {
        setFecha(DateHelper.getDefaultDate());
        setHoraInicio(DateHelper.getDefaultTime());
        setHoraFin(DateHelper.getDefaultTime());
        setPersonal(PersonalDTO.build());
    }

    public AgendaDTO(final int id, final LocalDate fecha, final LocalTime horaInicio, final LocalTime horaFin, final PersonalDTO personal) {
        setId(id);
        setFecha(fecha);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
        setPersonal(personal);
    }
    
    public static final AgendaDTO build() {
		return new AgendaDTO();
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

    public final PersonalDTO getPersonal() {
        return personal;
    }

    public final AgendaDTO  setId(final int id) {
        this.id = id;
        return this;
    }

    public final AgendaDTO setFecha(final LocalDate fecha) {
        this.fecha = fecha;
        return this;

    }

    public final AgendaDTO setHoraInicio(final LocalTime horaInicio) {
        this.horaInicio = horaInicio;
        return this;

    }

    public final AgendaDTO setHoraFin(final LocalTime horaFin) {
        this.horaFin = horaFin;
        return this;

    }

    public final AgendaDTO setPersonal(final PersonalDTO personal) {
        this.personal = ObjectHelper.getObjectHelper().getDefault(personal, PersonalDTO.build());
        return this;

    }
}
