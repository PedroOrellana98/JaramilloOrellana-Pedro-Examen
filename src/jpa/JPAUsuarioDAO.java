package jpa;

import javax.persistence.Persistence;

import dao.UsuarioDAO;
import entidad.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO{
	
	public JPAUsuarioDAO() {
		super(Usuario.class);
		this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}
		
	
}
