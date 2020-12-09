package dao;

import java.util.List;

import entidad.Telefono;
import entidad.Usuario;

public interface GenericDAO<T, ID> {
	
	public void create(T entity);
	
	public T read(ID id);
	
	public void update(T entity);
	public void delete(T entity);
	public List<T> find();
	public void deleteByID(ID id);
	
	List<T> findAll();

	Usuario buscar(String correo, String clave);

	List<Telefono> buscarCedula(String cedula);

	List<Usuario> buscarCorreo(String correo);
	
	
}
