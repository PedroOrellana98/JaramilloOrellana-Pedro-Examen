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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		Usuario usuario = new Usuario();
		System.out.println("Entro" );
		UsuarioDAO usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		
		sesion.setAttribute("accesos", sesion.getAttribute("accesos"));

		if (Integer.parseInt(request.getParameter("id")) == 1) {
			if (request.getParameter("correo") != null) {
				System.out.print("Correo: " + request.getParameter("correo"));
				request.setAttribute("telefono", usuarioDao.buscarCorreo(request.getParameter("correo")));
				getServletContext().getRequestDispatcher("/JSPs/Busquedas.jsp").forward(request, response);
			}
		}
			
		if (Integer.parseInt(request.getParameter("id")) == 2) {
			if (request.getParameter("cedula") != null) {
				System.out.print("Cedula: " + request.getParameter("cedula"));
				usuario = usuarioDao.read(request.getParameter("cedula"));
				request.setAttribute("usuario", usuario);
				request.setAttribute("telefono", usuarioDao.buscarCedula(request.getParameter("cedula")));
				getServletContext().getRequestDispatcher("/JSPs/Busquedas.jsp").forward(request, response);
			}
		} 
	}

}
