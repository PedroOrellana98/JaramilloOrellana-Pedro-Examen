package jpa;

import javax.persistence.Persistence;

import dao.TelefonoDAO;
import entidad.Telefono;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, String> implements TelefonoDAO{

	public JPATelefonoDAO() {
		super(Telefono.class);
		this.em = Persistence.createEntityManagerFactory("JaramilloOrellana-Pedro-Examen").createEntityManager();
	}
}
