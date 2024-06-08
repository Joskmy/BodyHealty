package co.edu.uco.bodyhealty.data.dao.general;

import java.util.List;

public interface BuscarDAO<E> {
	List<E> consultar(E entidad);
}
