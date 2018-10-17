package fr.eni.jee.bll.exam;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.User;
import fr.eni.jee.dal.EpreuveDAO;

/**
 * Servlet implementation class FinishTest
 */
@WebServlet("/Candidat/finishTest")
public class FinishTest extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinishTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		Exam exam = null;
		if (session.getAttribute("exam") != null) {
			exam = (Exam)session.getAttribute("exam");
			EpreuveDAO epreuveDAO = new EpreuveDAO();
			try {
				epreuveDAO.FinishTest(exam,user.getId());
				session.removeAttribute("exam");
				session.removeAttribute("examQuestions");
				request.setAttribute("message", "Votre test à été rendu avec succès.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// Envoi de l'erreur
				request.setAttribute("error", "Erreur lors de l'envoi de votre test. " + e.getMessage());
			}
			//JSP
			this.getServletContext().getRequestDispatcher("/Candidate/ManageTest/FinishExam.jsp").forward( request, response );
		}
		else{
			response.sendRedirect( request.getContextPath() + "/AccessDenied" );
		}
	}

}
