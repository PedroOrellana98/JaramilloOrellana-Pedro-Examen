package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.UsuarioDAO;
import entidad.Usuario;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String cedula;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearUsuario() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		
		cedula = null;
		String nombre = null;
		String apellido = null;
		String correo = null;
		String pwd = null;
		Usuario user = new Usuario();
		String accion = request.getParameter("resp");
		UsuarioDAO users = DAOFactory.getFactory().getUsuarioDAO();

		if (accion.equals("Registrarse")) {
			cedula = request.getParameter("cdi");
			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			correo = request.getParameter("email");
			pwd = request.getParameter("password");
			user = new Usuario(cedula, nombre, apellido, correo, pwd);
			users.create(user);
		}

		request.getRequestDispatcher("/JSPs/CrearTelefono.jsp").forward(request, response);
	}

}
