package dao;

import java.util.List;

import entidad.Telefono;
import entidad.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, String> {

	Usuario buscar(String correo, String clave);

	List<Telefono> buscarCedula(String cedula);
	
}
