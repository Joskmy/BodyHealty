package co.edu.uco.bodyhealty.data.dao.factory;

import co.edu.uco.bodyhealty.crosscutting.exceptions.custom.DataBodyHealtyException;
import co.edu.uco.bodyhealty.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.bodyhealty.data.dao.ServicioDAO;
import co.edu.uco.bodyhealty.data.dao.factory.enums.Factory;
import co.edu.uco.bodyhealty.data.dao.factory.sql.postgresql.PostgresSqlDAOFactory;
public abstract class DAOFactory {
	
	
	public static final DAOFactory getFactory(final Factory factory) {
		switch (factory) {

		case AZURESQL: {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00031);
			
			throw new DataBodyHealtyException(mensajeTecnico,mensajeUsuario);
			
		}
		case SQL_SERVER: {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00032);
			
			throw new DataBodyHealtyException(mensajeTecnico,mensajeUsuario);
		}
		case POSTGRESQL: {
		
			return new PostgresSqlDAOFactory();
		}
		case MYSQL: {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00033);
			
			throw new DataBodyHealtyException(mensajeTecnico,mensajeUsuario);
		}
		case ORACLE: {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00034);
			
			throw new DataBodyHealtyException(mensajeTecnico,mensajeUsuario);
		}
		default:{
			return new PostgresSqlDAOFactory();
		}
		}
	}

	protected abstract void obtenerConexion();

	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cancelarTransaccion();

	public abstract void cerrarConexion();

	public abstract ServicioDAO getServicioDAO();
}