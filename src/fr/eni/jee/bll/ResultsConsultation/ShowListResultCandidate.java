package fr.eni.jee.bll.ResultsConsultation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.User;
import fr.eni.jee.dal.UserDAO;

/**
 * Servlet implementation class ShowListResultCandidate
 */
@WebServlet("/Responsable/ShowListResultCandidate")
public class ShowListResultCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Manager/ManageResultsCandidate/ListResultCandidate.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowListResultCandidate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the list off candidate
		List<User> lstUserCandidate = new ArrayList<User>();

		try {
			lstUserCandidate = UserDAO.GetAllCandidats();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lstUserCandidate", lstUserCandidate);

		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> lstUserCandidate = new ArrayList<User>();

		String lastname = (String) request.getParameter("search");

		byte[] bytes = lastname.getBytes(StandardCharsets.ISO_8859_1);
		lastname = new String(bytes, StandardCharsets.UTF_8);

		try {
			lstUserCandidate = UserDAO.SearchByLastname(lastname);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lstUserCandidate", lstUserCandidate);

		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

}
