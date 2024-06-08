package co.edu.uco.bodyhealty.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.bodyhealty.business.domain.EstadoCitaDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.entity.EstadoCitaEntity;

public class EstadoCitaEntityDomainAssembler implements EntityDomainAssembler<EstadoCitaDomain, EstadoCitaEntity> {

    private static final EntityDomainAssembler<EstadoCitaDomain, EstadoCitaEntity> instancia = new EstadoCitaEntityDomainAssembler();

    private EstadoCitaEntityDomainAssembler() {
        super();
    }

    public static final EntityDomainAssembler<EstadoCitaDomain, EstadoCitaEntity> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final EstadoCitaDomain ensamblarDominio(final EstadoCitaEntity entidad) {
        var estadoCitaEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, EstadoCitaEntity.build(0, ""));
        return EstadoCitaDomain.crear(estadoCitaEntityTmp.getId(), estadoCitaEntityTmp.getEstado());
    }

    @Override
    public final EstadoCitaEntity ensablarEntidad(final EstadoCitaDomain dominio) {
        var estadoCitaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, EstadoCitaDomain.crear());
        return EstadoCitaEntity.build(estadoCitaDomainTmp.getId(), estadoCitaDomainTmp.getEstado());
    }

    @Override
    public final List<EstadoCitaDomain> ensamblarListaDominios(final List<EstadoCitaEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<EstadoCitaEntity>());
        var resultados = new ArrayList<EstadoCitaDomain>();

        for (EstadoCitaEntity estadoCitaEntity : listaEntidadesTmp) {
            var estadoCitaDomainTmp = ensamblarDominio(estadoCitaEntity);
            resultados.add(estadoCitaDomainTmp);
        }

        return resultados;
    }
}
