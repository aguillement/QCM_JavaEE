package fr.eni.jee.bll.ManagementQuestion;

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
import fr.eni.jee.bo.Theme;
import fr.eni.jee.dal.QuestionDAO;
import fr.eni.jee.dal.ThemeDAO;

/**
 * Servlet implementation class UpdateQuestion
 */
@WebServlet("/Formateur/updateQuestion")
public class UpdateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Former/ManagementQuestion/UpdateQuestion.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Question question = new Question();
		Integer idQuestionUpdate = Integer.parseInt(request.getParameter("id"));
		
		List<Theme> lstTheme = new ArrayList<Theme>();
		
		if(idQuestionUpdate != null){
			try {
				question = QuestionDAO.SearchByID(idQuestionUpdate);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			lstTheme = ThemeDAO.GetAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lstTheme", lstTheme);		
		request.setAttribute("question", question);
		request.setAttribute("idQuestion", question.getId());

		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		Question question = new Question();	
		question.setId(Integer.parseInt(request.getParameter("idQuestion")));
		question.setStatement(request.getParameter("statement"));
		question.setMedia(Integer.parseInt(request.getParameter("media")));
		question.setPoints(Integer.parseInt(request.getParameter("points")));
		
		Theme theme = new Theme();
		theme.setId(Integer.parseInt(request.getParameter("theme")));	

		question.setTheme(theme);

		try {
			QuestionDAO.Update(question);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

}
