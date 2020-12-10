package jpa;

import java.util.List;

import javax.persistence.Query;

import dao.UsuarioDAO;
import entidad.Telefono;
import entidad.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	
	public JPAUsuarioDAO() {
		super(Usuario.class);
		System.out.println("Hola");
	}
	
	@Override
	public Usuario buscar(String correo, String clave) {    
			System.out.println("Entro en la consulta");
		    Query nativeQuery = em.createNativeQuery("SELECT * FROM usuario WHERE correo = ? AND clave =? ", Usuario.class);
	        nativeQuery.setParameter(1, correo);
	        nativeQuery.setParameter(2, clave);
	        return (Usuario) nativeQuery.getSingleResult();
	}
	
	@Override
	public List<Telefono> buscarCedula(String cedula) {
		System.out.println("Entro en la consulta");
		Query nativeQuery = em.createNativeQuery("SELECT idTelefono, numero, tipo, operadora, Usuario_idUsuario FROM usuario, telefono WHERE telefono.Usuario_idUsuario=Usuario.idUsuario and usuario.cedula= ?", Telefono.class);
		 nativeQuery.setParameter(1, cedula);
		return (List<Telefono>)nativeQuery.getResultList();
	}
		
	
}
