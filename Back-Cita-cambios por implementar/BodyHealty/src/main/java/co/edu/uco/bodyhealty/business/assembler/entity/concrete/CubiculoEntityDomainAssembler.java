package co.edu.uco.bodyhealty.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.bodyhealty.business.domain.CubiculoDomain;
import co.edu.uco.bodyhealty.business.domain.TipoCubiculoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.entity.CubiculoEntity;
import co.edu.uco.bodyhealty.entity.TipoCubiculoEntity;

public class CubiculoEntityDomainAssembler implements EntityDomainAssembler<CubiculoDomain, CubiculoEntity> {

    private static final EntityDomainAssembler<CubiculoDomain, CubiculoEntity> instancia = new CubiculoEntityDomainAssembler();
    private static final EntityDomainAssembler<TipoCubiculoDomain, TipoCubiculoEntity> tipoCubiculoAssembler = TipoCubiculoEntityDomainAssembler.obtenerInstancia();

    private CubiculoEntityDomainAssembler() {
        super();
    }

    public static final EntityDomainAssembler<CubiculoDomain, CubiculoEntity> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final CubiculoDomain ensamblarDominio(final CubiculoEntity entidad) {
        var cubiculoEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, CubiculoEntity.build(0));
        var tipoCubiculoDominio = tipoCubiculoAssembler.ensamblarDominio(cubiculoEntityTmp.getTipoCubiculo());
        return CubiculoDomain.crear(cubiculoEntityTmp.getId(), tipoCubiculoDominio, cubiculoEntityTmp.getNombre());
    }

    @Override
    public final CubiculoEntity ensablarEntidad(final CubiculoDomain dominio) {
        var cubiculoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CubiculoDomain.crear());
        var tipoCubiculoEntity = tipoCubiculoAssembler.ensablarEntidad(cubiculoDomainTmp.getTipoCubiculo());
        return CubiculoEntity.build(cubiculoDomainTmp.getId(), tipoCubiculoEntity, cubiculoDomainTmp.getNombre());
    }

    @Override
    public final List<CubiculoDomain> ensamblarListaDominios(final List<CubiculoEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<CubiculoEntity>());
        var resultados = new ArrayList<CubiculoDomain>();

        for (CubiculoEntity cubiculoEntity : listaEntidadesTmp) {
            var cubiculoDomainTmp = ensamblarDominio(cubiculoEntity);
            resultados.add(cubiculoDomainTmp);
        }

        return resultados;
    }
}
