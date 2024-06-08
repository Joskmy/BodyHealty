package co.edu.uco.bodyhealty.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.bodyhealty.business.domain.TipoDocumentoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.dto.TipoDocumentoDTO;

public class TipoDocumentoDTODomainAssembler implements DTODomainAssembler<TipoDocumentoDomain, TipoDocumentoDTO> {

    private static final DTODomainAssembler<TipoDocumentoDomain, TipoDocumentoDTO> instancia = new TipoDocumentoDTODomainAssembler();

    private TipoDocumentoDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<TipoDocumentoDomain, TipoDocumentoDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final TipoDocumentoDomain ensamblarDominio(final TipoDocumentoDTO dto) {
        var tipoDocumentoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new TipoDocumentoDTO());
        return TipoDocumentoDomain.crear(tipoDocumentoDtoTmp.getId(), tipoDocumentoDtoTmp.getNombre());
    }

    @Override
    public final TipoDocumentoDTO ensamblarDTO(final TipoDocumentoDomain dominio) {
        var tipoDocumentoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, TipoDocumentoDomain.crear());
        return TipoDocumentoDTO.build().setId(tipoDocumentoDomainTmp.getId()).setNombre(tipoDocumentoDomainTmp.getNombre());
    }

    @Override
    public final List<TipoDocumentoDTO> ensamblarListaDTO(final List<TipoDocumentoDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<TipoDocumentoDomain>());
        var resultados = new ArrayList<TipoDocumentoDTO>();

        for (TipoDocumentoDomain tipoDocumentoDomain : listaDominiosTmp) {
            var tipoDocumentoDtoTmp = ensamblarDTO(tipoDocumentoDomain);
            resultados.add(tipoDocumentoDtoTmp);
        }

        return resultados;
    }
}
