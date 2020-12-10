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
import entidad.Usuario;
/**
 * Servlet implementation class BuscarPorCedula
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");

		String url = null;

		HttpSession sesion = request.getSession(true);

		sesion.setAttribute("accesos", sesion.getId());

			try {
				url="JSPs/Busqueda.jsp";
			} catch (Exception e) {
				url="index.jsp";
				System.out.println("Error en el login: " + e.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		HttpSession sesion = request.getSession();
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		String correo = null;
		String cedula = null;

		System.out.println("este es el id " + request.getParameter("id"));
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));
		

		if (Integer.parseInt(request.getParameter("id")) == 1) {
			if (request.getParameter("correo") != null) {
				correo = request.getParameter("correo");
				request.setAttribute("telefono", usuarioDao.buscarCorreo(correo));
				request.getRequestDispatcher("/JSPs/Busqueda.jsp").forward(request, response);
			}
		}else if (Integer.parseInt(request.getParameter("id")) == 2) {
			if (request.getParameter("cedula") != null) {
				cedula = request.getParameter("cedula");
				request.setAttribute("telefono", telefonoDao.buscarCedula(cedula));
				request.getRequestDispatcher("/JSPs/Busqueda.jsp").forward(request, response);
			}
		}
	}

}
