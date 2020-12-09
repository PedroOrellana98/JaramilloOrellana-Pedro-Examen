package jpa;

import dao.DAOFactory;
import dao.TelefonoDAO;
import dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		return new JPATelefonoDAO();
	}

}
