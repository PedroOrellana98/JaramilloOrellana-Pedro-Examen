package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.GenericDAO;
import entidad.Telefono;
import entidad.Usuario;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
	private Class<T> persistentClass;
	protected EntityManager em;
	
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
	}

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("INGRESANDO: /n");
			System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public T read(ID id) {
		// TODO Auto-generated method stub
		System.out.println("Buscando...");
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		System.out.println("Actualizando.....");
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		System.out.println("ELIMINANDO...");
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(ID id) {
		T entity = this.read(id);
		if (entity != null)
			this.delete(entity);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		List<T> lista = null;
		try {
			javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(persistentClass));
			lista = em.createQuery(cq).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@Override
	public List<Usuario> buscarCorreo(String correo) {
		Query nativeQuery = em.createNativeQuery("SELECT * FROM usuario, telefono WHERE telefono.Usuario_cedula=Usuario.cedula and usuario.correo= ?", Telefono.class);
		 nativeQuery.setParameter(1, correo);
		return (List<Usuario>) nativeQuery.getResultList();
	
	}

	@Override
	public Usuario buscar(String correo, String clave) {
		// TODO Auto-generated method stub
		Query nativeQuery = em.createNativeQuery("SELECT * FROM usuario WHERE correo = ? AND clave =? ", Usuario.class);
        nativeQuery.setParameter(1, correo);
        nativeQuery.setParameter(2, clave);
        return (Usuario) nativeQuery.getSingleResult();
	}

	@Override
	public List<Telefono> buscarCedula(String cedula) {
		Query nativeQuery = em.createNativeQuery("SELECT * FROM usuario, telefono WHERE telefono.Usuario_cedula=Usuario.cedula and usuario.cedula= ?", Telefono.class);
		 nativeQuery.setParameter(1, cedula);
		return (List<Telefono>)nativeQuery.getResultList();
	}


}