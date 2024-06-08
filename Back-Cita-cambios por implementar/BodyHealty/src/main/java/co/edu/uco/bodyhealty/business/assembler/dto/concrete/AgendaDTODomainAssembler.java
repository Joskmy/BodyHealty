package co.edu.uco.bodyhealty.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.bodyhealty.business.domain.AgendaDomain;
import co.edu.uco.bodyhealty.business.domain.PersonalDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.dto.AgendaDTO;
import co.edu.uco.bodyhealty.dto.PersonalDTO;

public class AgendaDTODomainAssembler implements DTODomainAssembler<AgendaDomain, AgendaDTO> {

    private static final DTODomainAssembler<AgendaDomain, AgendaDTO> instancia = new AgendaDTODomainAssembler();

    private static final DTODomainAssembler<PersonalDomain, PersonalDTO> personalAssembler = PersonalDTODomainAssembler.obtenerInstancia();

    private AgendaDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<AgendaDomain, AgendaDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final AgendaDomain ensamblarDominio(final AgendaDTO dto) {
        var agendaDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new AgendaDTO());
        var personalDomain = personalAssembler.ensamblarDominio(agendaDtoTmp.getPersonal());
        return AgendaDomain.crear(agendaDtoTmp.getId(), agendaDtoTmp.getFecha(), agendaDtoTmp.getHoraInicio(),
                agendaDtoTmp.getHoraFin(), personalDomain);
    }

    @Override
    public final AgendaDTO ensamblarDTO(final AgendaDomain dominio) {
        var agendaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, AgendaDomain.crear());
        var personalDTO = personalAssembler.ensamblarDTO(agendaDomainTmp.getPersonal());
        return AgendaDTO.build().setId(agendaDomainTmp.getId()).setFecha(agendaDomainTmp.getFecha())
                .setHoraInicio(agendaDomainTmp.getHoraInicio()).setHoraFin(agendaDomainTmp.getHoraFin()).setPersonal(personalDTO);
    }

    @Override
    public final List<AgendaDTO> ensamblarListaDTO(final List<AgendaDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<AgendaDomain>());
        var resultados = new ArrayList<AgendaDTO>();

        for (AgendaDomain agendaDomain : listaDominiosTmp) {
            var agendaDtoTmp = ensamblarDTO(agendaDomain);
            resultados.add(agendaDtoTmp);
        }

        return resultados;
    }
}
