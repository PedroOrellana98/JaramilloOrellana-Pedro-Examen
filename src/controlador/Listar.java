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

/**
 * Servlet implementation class Listar
 */
@WebServlet("/Listar")
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
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
				url="/JSPs/Listar.jsp";
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html:charset=UTF-8");
		
		TelefonoDAO telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		

		if (request.getParameter("id") != null) {
				request.setAttribute("telefono", telefonoDao.findAll());
				request.getRequestDispatcher("/JSPs/Listar.jsp").forward(request, response);
		}
	}

}
