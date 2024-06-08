package co.edu.uco.bodyhealty.business.assembler.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.bodyhealty.business.domain.TipoDocumentoDomain;
import co.edu.uco.bodyhealty.crosscutting.helpers.ObjectHelper;
import co.edu.uco.bodyhealty.entity.TipoDocumentoEntity;

public class TipoDocumentoEntityDomainAssembler implements EntityDomainAssembler<TipoDocumentoDomain, TipoDocumentoEntity> {
	private static final EntityDomainAssembler<TipoDocumentoDomain, TipoDocumentoEntity> instancia = new TipoDocumentoEntityDomainAssembler();

	private TipoDocumentoEntityDomainAssembler() {
		super();
	}

	public static final EntityDomainAssembler<TipoDocumentoDomain, TipoDocumentoEntity> obtenerInstancia() {
		return instancia;
	}

	@Override
	public final TipoDocumentoDomain ensamblarDominio(final TipoDocumentoEntity entidad) {
		var paisEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, TipoDocumentoEntity.build(0));
		return TipoDocumentoDomain.crear(paisEntityTmp.getId(), paisEntityTmp.getNombre());
	}

	@Override
	public final TipoDocumentoEntity ensablarEntidad(final TipoDocumentoDomain dominio) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, TipoDocumentoDomain.crear());
		return TipoDocumentoEntity.build(paisDomainTmp.getId(), paisDomainTmp.getNombre());
	}

	@Override
	public final List<TipoDocumentoDomain> ensamblarListaDominios(final List<TipoDocumentoEntity> listaEntidades) {
		var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<TipoDocumentoEntity>());
		var resultados = new ArrayList<TipoDocumentoDomain>();

		for (TipoDocumentoEntity paisEntity : listaEntidadesTmp) {
			var paisDomainTmp = ensamblarDominio(paisEntity);
			resultados.add(paisDomainTmp);
		}

		return resultados;
	}

}
