package co.edu.uco.bodyhealty.data.dao;

import co.edu.uco.bodyhealty.data.dao.general.AgregarDAO;
import co.edu.uco.bodyhealty.data.dao.general.ConsultarDAO;
import co.edu.uco.bodyhealty.entity.ServicioEntity;

public interface ServicioDAO
		extends AgregarDAO<ServicioEntity>, ConsultarDAO<ServicioEntity>{

}