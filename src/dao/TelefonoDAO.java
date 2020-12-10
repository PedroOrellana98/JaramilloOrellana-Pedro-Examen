package dao;

import java.util.List;
import entidad.Telefono;

public interface TelefonoDAO  extends GenericDAO<Telefono, String> {

	List<Telefono> buscarCedula(String cedula);
		
}
