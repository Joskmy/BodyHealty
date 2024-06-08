package co.edu.uco.bodyhealty.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.bodyhealty.business.domain.TipoCubiculoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.dto.TipoCubiculoDTO;

public final class TipoCubiculoDTODomainAssembler implements DTODomainAssembler<TipoCubiculoDomain, TipoCubiculoDTO> {

    private static final DTODomainAssembler<TipoCubiculoDomain, TipoCubiculoDTO> instancia = new TipoCubiculoDTODomainAssembler();

    private TipoCubiculoDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<TipoCubiculoDomain, TipoCubiculoDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final TipoCubiculoDomain ensamblarDominio(final TipoCubiculoDTO dto) {
        var tipoCubiculoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new TipoCubiculoDTO());
        return TipoCubiculoDomain.crear(tipoCubiculoDtoTmp.getId(), tipoCubiculoDtoTmp.getNombre());
    }

    @Override
    public final TipoCubiculoDTO ensamblarDTO(final TipoCubiculoDomain dominio) {
        var tipoCubiculoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, TipoCubiculoDomain.crear());
        return TipoCubiculoDTO.build().setId(tipoCubiculoDomainTmp.getId()).setNombre(tipoCubiculoDomainTmp.getNombre());
    }

    @Override
    public final List<TipoCubiculoDTO> ensamblarListaDTO(final List<TipoCubiculoDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<TipoCubiculoDomain>());
        var resultados = new ArrayList<TipoCubiculoDTO>();

        for (TipoCubiculoDomain tipoCubiculoDomain : listaDominiosTmp) {
            var tipoCubiculoDtoTmp = ensamblarDTO(tipoCubiculoDomain);
            resultados.add(tipoCubiculoDtoTmp);
        }

        return resultados;
    }
}