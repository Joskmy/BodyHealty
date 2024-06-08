package co.edu.uco.bodyhealty.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.bodyhealty.business.domain.EstadoCitaDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.dto.EstadoCitaDTO;

public class EstadoCitaDTODomainAssembler implements DTODomainAssembler<EstadoCitaDomain, EstadoCitaDTO> {

    private static final DTODomainAssembler<EstadoCitaDomain, EstadoCitaDTO> instancia = new EstadoCitaDTODomainAssembler();

    private EstadoCitaDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<EstadoCitaDomain, EstadoCitaDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final EstadoCitaDomain ensamblarDominio(final EstadoCitaDTO dto) {
        var estadoCitaDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new EstadoCitaDTO());
        return EstadoCitaDomain.crear(estadoCitaDtoTmp.getId(), estadoCitaDtoTmp.getEstado());
    }

    @Override
    public final EstadoCitaDTO ensamblarDTO(final EstadoCitaDomain dominio) {
        var estadoCitaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, EstadoCitaDomain.crear());
        return EstadoCitaDTO.build().setId(estadoCitaDomainTmp.getId()).setEstado(estadoCitaDomainTmp.getEstado());
    }

    @Override
    public final List<EstadoCitaDTO> ensamblarListaDTO(final List<EstadoCitaDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<EstadoCitaDomain>());
        var resultados = new ArrayList<EstadoCitaDTO>();

        for (EstadoCitaDomain estadoCitaDomain : listaDominiosTmp) {
            var estadoCitaDtoTmp = ensamblarDTO(estadoCitaDomain);
            resultados.add(estadoCitaDtoTmp);
        }

        return resultados;
    }
}
