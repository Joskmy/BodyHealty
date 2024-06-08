package co.edu.uco.bodyhealty.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.bodyhealty.business.domain.ServicioDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.entity.ServicioEntity;

public class ServicioEntityDomainAssembler implements EntityDomainAssembler<ServicioDomain, ServicioEntity> {
    private static final EntityDomainAssembler<ServicioDomain, ServicioEntity> instancia = new ServicioEntityDomainAssembler();

    private ServicioEntityDomainAssembler() {
        super();
    }

    public static final EntityDomainAssembler<ServicioDomain, ServicioEntity> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final ServicioDomain ensamblarDominio(final ServicioEntity entidad) {
        var servicioEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, ServicioEntity.build(0));
        return ServicioDomain.crear(servicioEntityTmp.getId(), servicioEntityTmp.getNombreServicio(), servicioEntityTmp.getDuracionEstimada(), servicioEntityTmp.getDescripcion());
    }

    @Override
    public final ServicioEntity ensablarEntidad(final ServicioDomain dominio) {
        var servicioDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, ServicioDomain.crear());
        return ServicioEntity.build(servicioDomainTmp.getId(), servicioDomainTmp.getNombreServicio(), servicioDomainTmp.getDuracionEstimada(), servicioDomainTmp.getDescripcion());
    }

    @Override
    public final List<ServicioDomain> ensamblarListaDominios(final List<ServicioEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<ServicioEntity>());
        var resultados = new ArrayList<ServicioDomain>();

        for (ServicioEntity servicioEntity : listaEntidadesTmp) {
            var servicioDomainTmp = ensamblarDominio(servicioEntity);
            resultados.add(servicioDomainTmp);
        }

        return resultados;
    }
}