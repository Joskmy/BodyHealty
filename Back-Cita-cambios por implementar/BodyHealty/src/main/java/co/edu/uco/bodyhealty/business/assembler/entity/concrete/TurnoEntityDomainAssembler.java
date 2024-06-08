package co.edu.uco.bodyhealty.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.bodyhealty.business.domain.AgendaDomain;
import co.edu.uco.bodyhealty.business.domain.TurnoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.entity.AgendaEntity;
import co.edu.uco.bodyhealty.entity.TurnoEntity;

public class TurnoEntityDomainAssembler implements EntityDomainAssembler<TurnoDomain, TurnoEntity> {

    private static final EntityDomainAssembler<TurnoDomain, TurnoEntity> instancia = new TurnoEntityDomainAssembler();
    private static final EntityDomainAssembler<AgendaDomain, AgendaEntity> agendaAssembler = AgendaEntityDomainAssembler.obtenerInstancia();

    private TurnoEntityDomainAssembler() {
        super();
    }

    public static final EntityDomainAssembler<TurnoDomain, TurnoEntity> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final TurnoDomain ensamblarDominio(final TurnoEntity entidad) {
        var turnoEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, TurnoEntity.build(0));
        var agendaDominio = agendaAssembler.ensamblarDominio(turnoEntityTmp.getAgenda());
        return TurnoDomain.crear(turnoEntityTmp.getId(), agendaDominio, turnoEntityTmp.getHoraInicio(), turnoEntityTmp.getHoraFin());
    }

    @Override
    public final TurnoEntity ensablarEntidad(final TurnoDomain dominio) {
        var turnoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, TurnoDomain.crear());
        var agendaEntity = agendaAssembler.ensablarEntidad(turnoDomainTmp.getAgenda());
        return TurnoEntity.build(turnoDomainTmp.getId(), agendaEntity, turnoDomainTmp.getHoraInicio(), turnoDomainTmp.getHoraFin());
    }

    @Override
    public final List<TurnoDomain> ensamblarListaDominios(final List<TurnoEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<TurnoEntity>());
        var resultados = new ArrayList<TurnoDomain>();

        for (TurnoEntity turnoEntity : listaEntidadesTmp) {
            var turnoDomainTmp = ensamblarDominio(turnoEntity);
            resultados.add(turnoDomainTmp);
        }

        return resultados;
    }
}
