package co.edu.uco.bodyhealty.business.usecase.concrete;

import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.entity.concrete.ServicioEntityDomainAssembler;
import co.edu.uco.bodyhealty.business.domain.ServicioDomain;
import co.edu.uco.bodyhealty.business.usecase.AgregarServicio;
import co.edu.uco.bodyhealty.crosscutting.exceptions.custom.BusinessBodyHealtyException;
import co.edu.uco.bodyhealty.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.bodyhealty.crosscutting.helpers.TextHelper;
import co.edu.uco.bodyhealty.data.dao.factory.DAOFactory;
import co.edu.uco.bodyhealty.entity.ServicioEntity;



public class AgregarServicioImpl implements AgregarServicio  {
	
	private final DAOFactory factory;
	
	public AgregarServicioImpl(final DAOFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void ejecutar(final ServicioDomain servicio) {
		
		validarDatosServicio(servicio);
		validarNoExistenciaServicio(servicio.getNombreServicio(), servicio.getDuracionEstimada(), servicio.getDescripcion());
	
		var servicioEntity = ServicioEntityDomainAssembler.obtenerInstancia().ensablarEntidad(servicio);
		factory.getServicioDAO().agregar(servicioEntity);
	
	}
	
	
	private void validarNoExistenciaServicio(String nombreServicio, int duracion, String descripcion) {
	    var servicioEntity = ServicioEntity.build(0, nombreServicio, duracion, descripcion);

	    final List<ServicioEntity> resultados = factory.getServicioDAO().consultar(servicioEntity);

	    if (!resultados.isEmpty()) {
	        var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00043);
	        throw new BusinessBodyHealtyException(mensajeUsuario);
	    }
	}
	
	private void validarDatosServicio(ServicioDomain servicio) {
	    if (TextHelper.isNullOrEmpty(servicio.getNombreServicio())) {
	        throw new BusinessBodyHealtyException(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00044));
	    }

	    if (servicio.getNombreServicio().length() > 80) {
	        throw new BusinessBodyHealtyException(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00047));
	    }

	    if (servicio.getDuracionEstimada() <= 0 || servicio.getDuracionEstimada() % 15 != 0) {
	        throw new BusinessBodyHealtyException(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00045));
	    }

	    if (TextHelper.isNullOrEmpty(servicio.getDescripcion())) {
	        throw new BusinessBodyHealtyException(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00046));
	    }

	    if (servicio.getDescripcion().length() > 500) {
	        throw new BusinessBodyHealtyException(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00048));
	    }
	}

		
    
}