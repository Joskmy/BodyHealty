package co.edu.uco.bodyhealty.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.bodyhealty.business.domain.CubiculoDomain;
import co.edu.uco.bodyhealty.business.domain.TipoCubiculoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.dto.CubiculoDTO;
import co.edu.uco.bodyhealty.dto.TipoCubiculoDTO;

public class CubiculoDTODomainAssembler implements DTODomainAssembler<CubiculoDomain, CubiculoDTO> {

    private static final CubiculoDTODomainAssembler instancia = new CubiculoDTODomainAssembler();

    private static final DTODomainAssembler<TipoCubiculoDomain, TipoCubiculoDTO> tipoCubiculoAssembler = TipoCubiculoDTODomainAssembler.obtenerInstancia();

    private CubiculoDTODomainAssembler() {
        super();
    }

    public static CubiculoDTODomainAssembler obtenerInstancia() {
        return instancia;
    }

    @Override
    public CubiculoDomain ensamblarDominio(CubiculoDTO dto) {
        var cubiculoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new CubiculoDTO());
        var tipoCubiculoDomain = tipoCubiculoAssembler.ensamblarDominio(cubiculoDtoTmp.getTipoCubiculo());
        return CubiculoDomain.crear(cubiculoDtoTmp.getId(), tipoCubiculoDomain, cubiculoDtoTmp.getNombre() );
    }

    @Override
    public CubiculoDTO ensamblarDTO(CubiculoDomain dominio) {
        var cubiculoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CubiculoDomain.crear());
        var tipoCubiculoDTO = tipoCubiculoAssembler.ensamblarDTO(cubiculoDomainTmp.getTipoCubiculo());
        return CubiculoDTO.build().setId(cubiculoDomainTmp.getId()).setNombre(cubiculoDomainTmp.getNombre())
                .setTipoCubiculo(tipoCubiculoDTO);
    }

    @Override
    public List<CubiculoDTO> ensamblarListaDTO(List<CubiculoDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<CubiculoDomain>());
        var resultados = new ArrayList<CubiculoDTO>();

        for (CubiculoDomain cubiculoDomain : listaDominiosTmp) {
            var cubiculoDtoTmp = ensamblarDTO(cubiculoDomain);
            resultados.add(cubiculoDtoTmp);
        }

        return resultados;
    }
}
