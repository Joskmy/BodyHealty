package co.edu.uco.bodyhealty.business.assembler.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.bodyhealty.business.domain.PersonalDomain;
import co.edu.uco.bodyhealty.business.domain.TipoDocumentoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.dto.PersonalDTO;
import co.edu.uco.bodyhealty.dto.TipoDocumentoDTO;

public class PersonalDTODomainAssembler implements DTODomainAssembler<PersonalDomain, PersonalDTO> {

    private static final DTODomainAssembler<PersonalDomain, PersonalDTO> instancia = new PersonalDTODomainAssembler();

    private static final DTODomainAssembler<TipoDocumentoDomain, TipoDocumentoDTO> tipoDocumentoAssembler = TipoDocumentoDTODomainAssembler.obtenerInstancia();

    private PersonalDTODomainAssembler() {
        super();
    }

    public static final DTODomainAssembler<PersonalDomain, PersonalDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public final PersonalDomain ensamblarDominio(final PersonalDTO dto) {
        var personalDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new PersonalDTO());
        var tipoDocumentoDomain = tipoDocumentoAssembler.ensamblarDominio(personalDtoTmp.getTipoDocumento());
        return PersonalDomain.crear(personalDtoTmp.getId(), tipoDocumentoDomain, personalDtoTmp.getNumeroDocumento(),
                personalDtoTmp.getPrimerNombre(), personalDtoTmp.getSegundoNombre(), personalDtoTmp.getPrimerApellido(),
                personalDtoTmp.getSegundoApellido(), personalDtoTmp.getCorreoElectronico(), personalDtoTmp.getTelefono(),
                personalDtoTmp.getCuenta(), personalDtoTmp.getContrasenia());
    }

    @Override
    public final PersonalDTO ensamblarDTO(final PersonalDomain dominio) {
        var personalDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, PersonalDomain.crear());
        var tipoDocumentoDTO = tipoDocumentoAssembler.ensamblarDTO(personalDomainTmp.getTipoId());
        return PersonalDTO.build().setId(personalDomainTmp.getId()).setTipoId(tipoDocumentoDTO)
                .setNumeroDocumento(personalDomainTmp.getNumeroDocumento()).setPrimerNombre(personalDomainTmp.getPrimerNombre())
                .setSegundoNombre(personalDomainTmp.getSegundoNombre()).setPrimerApellido(personalDomainTmp.getPrimerApellido())
                .setSegundoApellido(personalDomainTmp.getSegundoApellido()).setCorreoElectronico(personalDomainTmp.getCorreoElectronico())
                .setTelefono(personalDomainTmp.getTelefono()).setCuenta(personalDomainTmp.getCuenta())
                .setContrasenia(personalDomainTmp.getContrasenia());
    }

    @Override
    public final List<PersonalDTO> ensamblarListaDTO(final List<PersonalDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<PersonalDomain>());
        var resultados = new ArrayList<PersonalDTO>();

        for (PersonalDomain personalDomain : listaDominiosTmp) {
            var personalDtoTmp = ensamblarDTO(personalDomain);
            resultados.add(personalDtoTmp);
        }

        return resultados;
    }
}
