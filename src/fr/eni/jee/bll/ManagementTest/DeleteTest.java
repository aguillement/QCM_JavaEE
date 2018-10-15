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

import fr.eni.jee.bo.Test;
import fr.eni.jee.dal.TestDAO;

/**
 * Servlet implementation class DeleteTest
 */
@WebServlet("/Formateur/deleteTest")
public class DeleteTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Former/ManagementQuestion/ListQuestion.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Test test = new Test();
		test.setId(Integer.parseInt(request.getParameter("idTest")));

		try {
			TestDAO.Delete(test);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<Test> lstTest = new ArrayList<Test>();

		try {
			lstTest = TestDAO.GetAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lstTest", lstTest);

		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

}
