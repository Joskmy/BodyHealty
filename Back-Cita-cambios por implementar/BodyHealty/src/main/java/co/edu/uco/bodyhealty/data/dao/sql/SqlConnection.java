package co.edu.uco.bodyhealty.data.dao.sql;

import java.sql.Connection;

import co.edu.uco.bodyhealty.crosscutting.exceptions.custom.DataBodyHealtyException;
import co.edu.uco.bodyhealty.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.bodyhealty.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.bodyhealty.crosscutting.helpers.SQLHelper;

public class SqlConnection {
	private Connection connection;

	protected SqlConnection(final Connection connection) {
		setConnection(connection);
	}

	private final void setConnection(final Connection connection) {
		if (!SQLHelper.isNull(connection)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No es posible crear el DAO deseado, dado que la conexión SQL está cerrada";

			throw new DataBodyHealtyException(mensajeTecnico, mensajeUsuario);
		}
		this.connection = connection;
	}

	protected final Connection getConnection() {
		return connection;
	}
}
