package controlador;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.TelefonoDAO;
import dao.UsuarioDAO;
import entidad.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HttpSession sesion = request.getSession(true);
		
		sesion.setAttribute("accesos", sesion.getId());
		System.out.println("Inicio de sesion: "+ sesion.getId());
		
		getServletContext().getRequestDispatcher("JSPs/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		System.out.print("Iniciar Sesion \n");

		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		String correo = "";
		String contrasena = "";

		String accion = request.getParameter("resp");
		Usuario user = new Usuario();

		if (accion.equals("Login")) {
			correo = request.getParameter("user");
			contrasena = request.getParameter("password");
			user = usuarioDao.buscar(correo, contrasena);
		}
		try {
			if (user != null) {
				TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
				request.setAttribute("telefono", telefonoDao.buscarCedula(user.getCedula()));
				request.setAttribute("usuario", user);
				getServletContext().getRequestDispatcher("/JSPs/IndexUsuario.jsp").forward(request, response);
			} else {
				getServletContext().getRequestDispatcher("/JSps/login.jsp").forward(request, response);
			}
		}catch (Exception e) {
			System.out.println(">>>ERROR:IniciarSesion:DOPOST "+e.getMessage());
		}
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
