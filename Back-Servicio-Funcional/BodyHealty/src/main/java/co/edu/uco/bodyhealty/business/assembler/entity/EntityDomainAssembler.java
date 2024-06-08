package co.edu.uco.bodyhealty.business.assembler.entity;

import java.util.List;

public interface EntityDomainAssembler<D, E> {
	D ensamblarDominio(E entidad);

	E ensablarEntidad(D dominio);
	
	List<D> ensamblarListaDominios(List<E> listaEntidades);

}
