package fr.eni.jee.bll;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.User;
import fr.eni.jee.form.AddCandidatForm;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/Responsable/utilisateur/ajouter")
public class AddUser extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/Manager/ManageUser/CreateCandidate.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Init variables */
		AddCandidatForm form = new AddCandidatForm();

		// Set the value of the codeProfil
		form.setValueProfil(20);

		/* Check all input and init the user */
		User newCandidat = form.initUserForm(request);
		boolean isInsert = false;
		if (newCandidat != null) {
			isInsert = true;
		}
		request.setAttribute("isInsert", isInsert);
		request.setAttribute("message", form.getResults());

		this.getServletContext().getRequestDispatcher("/Manager/ManageUser/CreateCandidate.jsp").forward(request,
				response);

	}

}
