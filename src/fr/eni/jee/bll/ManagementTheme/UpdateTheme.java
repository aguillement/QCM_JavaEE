package fr.eni.jee.bll.ManagementTheme;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateTheme
 */
@WebServlet("/Formateur/updateTheme")
public class UpdateTheme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Former/ManagementTheme/UpdateTheme.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTheme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

}
