package co.edu.uco.bodyhealty.dto;

import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;

public final class CitaDTO {
	private int id;
    private PacienteDTO paciente;
    private TurnoDTO turno;
    private ServicioDTO servicio;
    private CubiculoDTO cubiculo;
    private EstadoCitaDTO estadoCita;

    public CitaDTO() {
        setPaciente(PacienteDTO.build());
        setTurno(TurnoDTO.build());
        setServicio(ServicioDTO.build());
        setCubiculo(CubiculoDTO.build());
        setEstadoCita(EstadoCitaDTO.build());
    }

    public CitaDTO(final int id, final PacienteDTO paciente, final TurnoDTO turno, final ServicioDTO servicio, final CubiculoDTO cubiculo, final EstadoCitaDTO estadoCita) {
        setId(id);
        setPaciente(paciente);
        setTurno(turno);
        setServicio(servicio);
        setCubiculo(cubiculo);
        setEstadoCita(estadoCita);
    }

    public static final CitaDTO build() {
        return new CitaDTO();
    }

    public final int getId() {
        return id;
    }

    public final PacienteDTO getPaciente() {
        return paciente;
    }

    public final TurnoDTO getTurno() {
        return turno;
    }

    public final ServicioDTO getServicio() {
        return servicio;
    }

    public final CubiculoDTO getCubiculo() {
        return cubiculo;
    }

    public final EstadoCitaDTO getEstadoCita() {
        return estadoCita;
    }

    public final CitaDTO setId(final int id) {
        this.id = id;
        return this;
    }

    public final CitaDTO setPaciente(final PacienteDTO paciente) {
        this.paciente = ObjectHelper.getObjectHelper().getDefault(paciente, PacienteDTO.build());
        return this;
    }

    public final CitaDTO setTurno(final TurnoDTO turno) {
        this.turno = ObjectHelper.getObjectHelper().getDefault(turno, TurnoDTO.build());
        return this;
    }

    public final CitaDTO setServicio(final ServicioDTO servicio) {
        this.servicio = ObjectHelper.getObjectHelper().getDefault(servicio, ServicioDTO.build());
        return this;
    }

    public final CitaDTO setCubiculo(final CubiculoDTO cubiculo) {
        this.cubiculo = ObjectHelper.getObjectHelper().getDefault(cubiculo, CubiculoDTO.build());
        return this;
    }

    public final CitaDTO setEstadoCita(final EstadoCitaDTO estadoCita) {
        this.estadoCita = ObjectHelper.getObjectHelper().getDefault(estadoCita, EstadoCitaDTO.build());
        return this;
    }
}
