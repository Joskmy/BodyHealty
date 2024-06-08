package co.edu.uco.bodyhealty.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.bodyhealty.business.domain.PacienteDomain;
import co.edu.uco.bodyhealty.business.domain.TipoDocumentoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.entity.PacienteEntity;
import co.edu.uco.bodyhealty.entity.TipoDocumentoEntity;

public class PacienteEntityDomainAssembler implements EntityDomainAssembler<PacienteDomain, PacienteEntity> {

    private static final EntityDomainAssembler<PacienteDomain, PacienteEntity> instancia = new PacienteEntityDomainAssembler();

    private static final EntityDomainAssembler<TipoDocumentoDomain, TipoDocumentoEntity> tipoDocumentoAssembler = TipoDocumentoEntityDomainAssembler.obtenerInstancia();

    private PacienteEntityDomainAssembler() {
        super();
    }

    public static final EntityDomainAssembler<PacienteDomain, PacienteEntity> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final PacienteDomain ensamblarDominio(final PacienteEntity entidad) {
        var pacienteEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, PacienteEntity.build(0));
        var tipoDocumentoDominio = tipoDocumentoAssembler.ensamblarDominio(pacienteEntityTmp.getTipoId());
        return PacienteDomain.crear(pacienteEntityTmp.getId(), tipoDocumentoDominio, pacienteEntityTmp.getNumeroDocumento(),
                pacienteEntityTmp.getPrimerNombre(), pacienteEntityTmp.getSegundoNombre(), pacienteEntityTmp.getPrimerApellido(),
                pacienteEntityTmp.getSegundoApellido(), pacienteEntityTmp.getCorreoElectronico(), pacienteEntityTmp.getTelefono(),
                pacienteEntityTmp.getCuenta(), pacienteEntityTmp.getContrasenia());
    }

    @Override
    public final PacienteEntity ensablarEntidad(final PacienteDomain dominio) {
        var pacienteDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, PacienteDomain.crear());
        var tipoDocumentoEntity = tipoDocumentoAssembler.ensablarEntidad(pacienteDomainTmp.getTipoId());
        return PacienteEntity.build(pacienteDomainTmp.getId(), tipoDocumentoEntity, pacienteDomainTmp.getNumeroDocumento(),
                pacienteDomainTmp.getPrimerNombre(), pacienteDomainTmp.getSegundoNombre(), pacienteDomainTmp.getPrimerApellido(),
                pacienteDomainTmp.getSegundoApellido(), pacienteDomainTmp.getCorreoElectronico(), pacienteDomainTmp.getTelefono(),
                pacienteDomainTmp.getCuenta(), pacienteDomainTmp.getContrasenia());
    }

    @Override
    public final List<PacienteDomain> ensamblarListaDominios(final List<PacienteEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<PacienteEntity>());
        var resultados = new ArrayList<PacienteDomain>();

        for (PacienteEntity pacienteEntity : listaEntidadesTmp) {
            var pacienteDomainTmp = ensamblarDominio(pacienteEntity);
            resultados.add(pacienteDomainTmp);
        }

        return resultados;
    }
}
