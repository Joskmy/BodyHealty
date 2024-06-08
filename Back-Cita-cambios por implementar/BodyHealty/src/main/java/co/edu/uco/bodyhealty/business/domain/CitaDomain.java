package co.edu.uco.bodyhealty.business.domain;

import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;

public class CitaDomain {
	private int id;
    private PacienteDomain paciente;
    private TurnoDomain turno;
    private ServicioDomain servicio;
    private CubiculoDomain cubiculo;
    private EstadoCitaDomain estadoCita;

    private CitaDomain() {
    	setId(id);
        setPaciente(paciente);
        setTurno(turno);
        setServicio(servicio);
        setCubiculo(cubiculo);
        setEstadoCita(estadoCita);
    }

    private CitaDomain(final int id, final PacienteDomain paciente, final TurnoDomain turno, final ServicioDomain servicio, final CubiculoDomain cubiculo, final EstadoCitaDomain estadoCita) {
        
        
        setPaciente(PacienteDomain.crear());
        setTurno(TurnoDomain.crear());
        setServicio(ServicioDomain.crear());
        setCubiculo(CubiculoDomain.crear());
        setEstadoCita(EstadoCitaDomain.crear());
    }

    public static final CitaDomain crear(final int id, final PacienteDomain paciente, final TurnoDomain turno, final ServicioDomain servicio, final CubiculoDomain cubiculo, final EstadoCitaDomain estadoCita) {
        return new CitaDomain(id, paciente, turno, servicio, cubiculo, estadoCita);
    }
    
    public static final CitaDomain crear() {
		return new CitaDomain();
	}
    

    public final int getId() {
        return id;
    }

    public final PacienteDomain getPaciente() {
        return paciente;
    }

    public final TurnoDomain getTurno() {
        return turno;
    }

    public final ServicioDomain getServicio() {
        return servicio;
    }

    public final CubiculoDomain getCubiculo() {
        return cubiculo;
    }

    public final EstadoCitaDomain getEstadoCita() {
        return estadoCita;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final void setPaciente(final PacienteDomain paciente) {
        this.paciente = ObjectHelper.getObjectHelper().getDefault(paciente, PacienteDomain.crear());

    }

    public final void setTurno(final TurnoDomain turno) {
        this.turno = ObjectHelper.getObjectHelper().getDefault(turno, TurnoDomain.crear());
    }

    public final void setServicio(final ServicioDomain servicio) {
        this.servicio = ObjectHelper.getObjectHelper().getDefault(servicio, ServicioDomain.crear());
    }

    public final void setCubiculo(final CubiculoDomain cubiculo) {
        this.cubiculo = ObjectHelper.getObjectHelper().getDefault(cubiculo, CubiculoDomain.crear());
    }

    public final void setEstadoCita(final EstadoCitaDomain estadoCita) {
        this.estadoCita = ObjectHelper.getObjectHelper().getDefault(estadoCita, EstadoCitaDomain.crear());
    }
}
