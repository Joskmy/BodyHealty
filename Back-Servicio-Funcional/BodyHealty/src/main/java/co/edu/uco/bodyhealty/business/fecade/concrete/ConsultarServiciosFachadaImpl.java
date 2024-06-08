package co.edu.uco.bodyhealty.business.fecade.concrete;

import java.util.List;

import co.edu.uco.bodyhealty.business.assembler.dto.concrete.ServicioDTODomainAssembler;
import co.edu.uco.bodyhealty.business.fecade.ConsultarServiciosFachada;
import co.edu.uco.bodyhealty.business.usecase.ConsultarServicios;
import co.edu.uco.bodyhealty.business.usecase.concrete.ConsultarServiciosImpl;
import co.edu.uco.bodyhealty.crosscutting.exceptions.BodyHealtyException;
import co.edu.uco.bodyhealty.crosscutting.exceptions.custom.BusinessBodyHealtyException;
import co.edu.uco.bodyhealty.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.bodyhealty.data.dao.factory.DAOFactory;
import co.edu.uco.bodyhealty.data.dao.factory.enums.Factory;
import co.edu.uco.bodyhealty.dto.ServicioDTO;

public final class ConsultarServiciosFachadaImpl implements ConsultarServiciosFachada {

	private DAOFactory factory;

	public ConsultarServiciosFachadaImpl() {
		factory = DAOFactory.getFactory(Factory.POSTGRESQL);
	}

	@Override
	public final List<ServicioDTO> execute(final ServicioDTO pais) {
		try {
			var servicioDomain = ServicioDTODomainAssembler.obtenerInstancia().ensamblarDominio(pais);

			final ConsultarServicios useCase = new ConsultarServiciosImpl(factory);
			var resultados = useCase.ejecutar(servicioDomain);
			return ServicioDTODomainAssembler.obtenerInstancia().ensamblarListaDTO(resultados);

		} catch (final BodyHealtyException exception) {
			throw exception;
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00037);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00038);
			throw new BusinessBodyHealtyException(mensajeTecnico, mensajeUsuario);
		} finally {
			factory.cerrarConexion();
		}
	}

}
