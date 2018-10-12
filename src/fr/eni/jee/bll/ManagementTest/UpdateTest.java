package fr.eni.jee.bll.ManagementTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateTest
 */
@WebServlet("/Formateur/updateTest")
public class UpdateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Former/ManageTest/UpdateTest.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTest() {
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
