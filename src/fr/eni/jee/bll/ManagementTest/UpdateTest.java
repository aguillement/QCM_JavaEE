package fr.eni.jee.bll.ManagementTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.Question;
import fr.eni.jee.bo.Test;
import fr.eni.jee.bo.Theme;
import fr.eni.jee.dal.QuestionDAO;
import fr.eni.jee.dal.TestDAO;
import fr.eni.jee.dal.ThemeDAO;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Test test = new Test();
		Integer idTestUpdate = Integer.parseInt(request.getParameter("id"));
		
		List<Test> lstTest = new ArrayList<Test>();
		
		if(idTestUpdate != null){
			try {
				test = TestDAO.SearchByID(idTestUpdate);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			lstTest = TestDAO.GetAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lstTest", lstTest);		
		request.setAttribute("test", test);
		request.setAttribute("idTest", test.getId());
		
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		Test test = new Test();	
		test.setId(Integer.parseInt(request.getParameter("idTest")));
		test.setLabel(request.getParameter("label"));
		test.setStatement(request.getParameter("statement"));
		test.setDuration(Integer.parseInt(request.getParameter("duration")));
		test.setHigh_level(Integer.parseInt(request.getParameter("high_level")));
		test.setLow_level(Integer.parseInt(request.getParameter("low_level")));

		try {
			TestDAO.Update(test);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}
}
