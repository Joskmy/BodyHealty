package co.edu.uco.bodyhealty.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.bodyhealty.business.domain.PacienteDomain;
import co.edu.uco.bodyhealty.business.domain.TipoDocumentoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.dto.PacienteDTO;
import co.edu.uco.bodyhealty.dto.TipoDocumentoDTO;

public class PacienteDTODomainAssembler implements DTODomainAssembler<PacienteDomain, PacienteDTO> {

    private static final DTODomainAssembler<PacienteDomain, PacienteDTO> instancia = new PacienteDTODomainAssembler();

    private static final DTODomainAssembler<TipoDocumentoDomain, TipoDocumentoDTO> tipoDocumentoAssembler = TipoDocumentoDTODomainAssembler.obtenerInstancia();

    private PacienteDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<PacienteDomain, PacienteDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final PacienteDomain ensamblarDominio(final PacienteDTO dto) {
        var pacienteDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new PacienteDTO());
        var tipoDocumentoDomain = tipoDocumentoAssembler.ensamblarDominio(pacienteDtoTmp.getTipoId());
        return PacienteDomain.crear(pacienteDtoTmp.getId(), tipoDocumentoDomain, pacienteDtoTmp.getNumeroDocumento(),
                pacienteDtoTmp.getPrimerNombre(), pacienteDtoTmp.getSegundoNombre(), pacienteDtoTmp.getPrimerApellido(),
                pacienteDtoTmp.getSegundoApellido(), pacienteDtoTmp.getCorreoElectronico(), pacienteDtoTmp.getTelefono(),
                pacienteDtoTmp.getCuenta(), pacienteDtoTmp.getContrasenia());
    }

    @Override
    public final PacienteDTO ensamblarDTO(final PacienteDomain dominio) {
        var pacienteDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, PacienteDomain.crear());
        var tipoDocumentoDTO = tipoDocumentoAssembler.ensamblarDTO(pacienteDomainTmp.getTipoId());
        return PacienteDTO.build().setId(pacienteDomainTmp.getId()).setTipoId(tipoDocumentoDTO)
                .setNumeroDocumento(pacienteDomainTmp.getNumeroDocumento()).setPrimerNombre(pacienteDomainTmp.getPrimerNombre())
                .setSegundoNombre(pacienteDomainTmp.getSegundoNombre()).setPrimerApellido(pacienteDomainTmp.getPrimerApellido())
                .setSegundoApellido(pacienteDomainTmp.getSegundoApellido()).setCorreoElectronico(pacienteDomainTmp.getCorreoElectronico())
                .setTelefono(pacienteDomainTmp.getTelefono()).setCuenta(pacienteDomainTmp.getCuenta())
                .setContrasenia(pacienteDomainTmp.getContrasenia());
    }

    @Override
    public final List<PacienteDTO> ensamblarListaDTO(final List<PacienteDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<PacienteDomain>());
        var resultados = new ArrayList<PacienteDTO>();

        for (PacienteDomain pacienteDomain : listaDominiosTmp) {
            var pacienteDtoTmp = ensamblarDTO(pacienteDomain);
            resultados.add(pacienteDtoTmp);
        }

        return resultados;
    }
}
