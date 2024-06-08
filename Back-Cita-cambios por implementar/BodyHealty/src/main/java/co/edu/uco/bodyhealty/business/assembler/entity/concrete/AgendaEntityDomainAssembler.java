package co.edu.uco.bodyhealty.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.bodyhealty.business.domain.AgendaDomain;
import co.edu.uco.bodyhealty.business.domain.PersonalDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.entity.AgendaEntity;
import co.edu.uco.bodyhealty.entity.PersonalEntity;

public class AgendaEntityDomainAssembler implements EntityDomainAssembler<AgendaDomain, AgendaEntity> {

    private static final EntityDomainAssembler<AgendaDomain, AgendaEntity> instancia = new AgendaEntityDomainAssembler();
    private static final EntityDomainAssembler<PersonalDomain, PersonalEntity> personalAssembler = PersonalEntityDomainAssembler.obtenerInstancia();

    private AgendaEntityDomainAssembler() {
        super();
    }

    public static final EntityDomainAssembler<AgendaDomain, AgendaEntity> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final AgendaDomain ensamblarDominio(final AgendaEntity entidad) {
        var agendaEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, AgendaEntity.build(0));
        var personalDominio = personalAssembler.ensamblarDominio(agendaEntityTmp.getPersonal());
        return AgendaDomain.crear(agendaEntityTmp.getId(), agendaEntityTmp.getFecha(), agendaEntityTmp.getHoraInicio(), agendaEntityTmp.getHoraFin(), personalDominio);
    }

    @Override
    public final AgendaEntity ensablarEntidad(final AgendaDomain dominio) {
        var agendaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, AgendaDomain.crear());
        var personalEntity = personalAssembler.ensablarEntidad(agendaDomainTmp.getPersonal());
        return AgendaEntity.build(agendaDomainTmp.getId(), agendaDomainTmp.getFecha(), agendaDomainTmp.getHoraInicio(), agendaDomainTmp.getHoraFin(), personalEntity);
    }

    @Override
    public final List<AgendaDomain> ensamblarListaDominios(final List<AgendaEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<AgendaEntity>());
        var resultados = new ArrayList<AgendaDomain>();

        for (AgendaEntity agendaEntity : listaEntidadesTmp) {
            var agendaDomainTmp = ensamblarDominio(agendaEntity);
            resultados.add(agendaDomainTmp);
        }

        return resultados;
    }
}
