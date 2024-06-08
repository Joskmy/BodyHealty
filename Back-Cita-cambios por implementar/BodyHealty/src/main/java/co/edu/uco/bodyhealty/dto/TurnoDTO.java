package co.edu.uco.bodyhealty.dto;

import java.time.LocalTime;

import co.edu.uco.bodyhealty.crosscutting.helpers.DateHelper;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;

public final class TurnoDTO {
	 private int id;
	    private AgendaDTO agenda;
	    private LocalTime horaInicio;
	    private LocalTime horaFin;

	    public TurnoDTO() {
	        setAgenda(AgendaDTO.build());
	        setHoraInicio(DateHelper.getDefaultTime());
	        setHoraFin(DateHelper.getDefaultTime());
	    }

	    public TurnoDTO(final int id, final AgendaDTO agenda, final LocalTime horaInicio, final LocalTime horaFin) {
	        setId(id);
	        setAgenda(agenda);
	        setHoraInicio(horaInicio);
	        setHoraFin(horaFin);
	    }
	    
	    public static final TurnoDTO build() {
			return new TurnoDTO();
		}

	    public final int getId() {
	        return id;
	    }

	    public final AgendaDTO getAgenda() {
	        return agenda;
	    }

	    public final LocalTime getHoraInicio() {
	        return horaInicio;
	    }

	    public final LocalTime getHoraFin() {
	        return horaFin;
	    }

	    public final TurnoDTO setId(final int id) {
	        this.id = id;
	        return this;
	    }

	    public final TurnoDTO setAgenda(final AgendaDTO agenda) {
	        this.agenda = ObjectHelper.getObjectHelper().getDefault(agenda, AgendaDTO.build());
	        return this;
	    }

	    public final TurnoDTO setHoraInicio(final LocalTime horaInicio) {
	        this.horaInicio = horaInicio;
	        return this;
	    }

	    public final TurnoDTO setHoraFin(final LocalTime horaFin) {
	        this.horaFin = horaFin;
	        return this;
	    }
}
