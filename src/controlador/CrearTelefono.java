package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.TelefonoDAO;
import dao.UsuarioDAO;
import entidad.Telefono;
import entidad.Usuario;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearTelefono() {
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
		
		String numero = null;
		String tipo = null;
		String operadora = null;
		String accion = request.getParameter("resp");
		Telefono telefono = new Telefono();
		Usuario usuario = new Usuario();
		TelefonoDAO telefonos = DAOFactory.getFactory().getTelefonoDAO();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();

		if (accion.equals("Registrarse")) {
			numero = request.getParameter("numero");
			tipo = request.getParameter("tipo");
			operadora = request.getParameter("operadora");
			usuario=usuarioDao.read(request.getParameter("cedula"));
			System.out.println("datos recolectados "+numero +", "+operadora+", "+tipo+","+ usuario);
			
			
			telefono = new Telefono(numero, tipo, operadora, usuario);
			telefonos.create(telefono);
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
