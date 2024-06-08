package co.edu.uco.bodyhealty.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.bodyhealty.business.domain.ServicioDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.dto.ServicioDTO;

public class ServicioDTODomainAssembler implements DTODomainAssembler<ServicioDomain, ServicioDTO> {

    private static final DTODomainAssembler<ServicioDomain, ServicioDTO> instancia = new ServicioDTODomainAssembler();

    private ServicioDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<ServicioDomain, ServicioDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final ServicioDomain ensamblarDominio(final ServicioDTO dto) {
        var servicioDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new ServicioDTO());
        return ServicioDomain.crear(servicioDtoTmp.getId(), servicioDtoTmp.getNombreServicio(), servicioDtoTmp.getDuracionEstimada(), servicioDtoTmp.getDescripcion());
    }

    @Override
    public final ServicioDTO ensamblarDTO(final ServicioDomain dominio) {
        var servicioDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, ServicioDomain.crear());
        return ServicioDTO.build().setId(servicioDomainTmp.getId()).setNombreServicio(servicioDomainTmp.getNombreServicio()).setDuracionEstimada(servicioDomainTmp.getDuracionEstimada()).setDescripcion(servicioDomainTmp.getDescripcion());
    }

    @Override
    public final List<ServicioDTO> ensamblarListaDTO(final List<ServicioDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<ServicioDomain>());
        var resultados = new ArrayList<ServicioDTO>();

        for (ServicioDomain servicioDomain : listaDominiosTmp) {
            var servicioDtoTmp = ensamblarDTO(servicioDomain);
            resultados.add(servicioDtoTmp);
        }

        return resultados;
    }
}
