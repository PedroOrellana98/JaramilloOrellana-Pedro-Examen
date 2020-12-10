package test;

import dao.DAOFactory;
import dao.TelefonoDAO;
import dao.UsuarioDAO;
import entidad.Telefono;
import entidad.Usuario;

public class testUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDAO user = DAOFactory.getFactory().getUsuarioDAO();
		
		Usuario u1 = new Usuario("0104978135", "Pedro", "Orellana", "pedrorellana1998@gmail.com", "123");
		Usuario u2 = new Usuario("0300934692", "Tania", "Jaramillo", "taniaesja@gmail.com", "123");
		
		user.create(u1);
		user.create(u2);
		System.out.println("Usuarios Creados");
		
		//Comprobar que funciona funcion login
		System.out.println(user.buscar("pedrorellana1998@gmail.com", "123"));
		
		TelefonoDAO telf = DAOFactory.getFactory().getTelefonoDAO();
		
		System.out.println(user.findAll());
		System.out.println(user.read("0300934692"));
		Usuario u3 = new Usuario();
		u3 = user.read("0104978135");
		System.out.println(u3);
		Telefono t1 = new Telefono("0998550859", "Celular", "Movistar", u1);
		
		telf.create(t1);
		System.out.println("Telef creado");
		
		System.out.println(telf.buscarCedula("0104978135"));
		System.out.println(telf.findAll());
		System.out.println(user.read("0104978135"));
		//System.out.println(telf.buscarCorreo("pedrorellana1998@gmail.com"));
	}
}
