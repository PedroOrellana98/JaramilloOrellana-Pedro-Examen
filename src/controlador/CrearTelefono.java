package controlador;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import dao.TelefonoDAO;
import dao.UsuarioDAO;
import entidad.Telefono;
import entidad.Usuario;

/**
 * Servlet implementation class CrearTelefono
 */
@WebServlet("/CrearTelefono")
public class CrearTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearTelefono() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		
		String numero = null;
		String tipo = null;
		String operadora = null;
		String cedula = CrearUsuario.cedula;
		String accion = request.getParameter("resp");
		Telefono telefono = new Telefono();
		Usuario usuario = new Usuario();
		TelefonoDAO telefonos = DAOFactory.getFactory().getTelefonoDAO();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();

		if (accion.equals("Registrarse")) {
			numero = request.getParameter("numero");
			tipo = request.getParameter("tipo");
			operadora = request.getParameter("operadora");
			usuario=usuarioDao.read(cedula);
			System.out.println(usuario);
			System.out.println("datos recolectados "+numero +", "+operadora+", "+tipo+","+ usuario);
			
			
			telefono = new Telefono(numero, tipo, operadora, usuario);
			telefonos.create(telefono);
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
