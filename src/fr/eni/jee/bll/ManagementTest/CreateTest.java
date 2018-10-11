package fr.eni.jee.bll.ManagementTest;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.Test;
import fr.eni.jee.dal.TestDAO;

/**
 * Servlet implementation class CreateTest
 */
@WebServlet("/CreateTest")
public class CreateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/Restricted/ManageTest/CreateTest.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTest() {
        super();
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
		
		Test test = new Test();
		test.setLabel(request.getParameter("label"));
		test.setStatement(request.getParameter("statement"));
		test.setDuration(Integer.parseInt(request.getParameter("duration")));
		test.setHigh_level(Integer.parseInt(request.getParameter("high_level")));
		test.setLow_level(Integer.parseInt(request.getParameter("low_level")));
		
		try {
			TestDAO.Insert(test);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

}
