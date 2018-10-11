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
 * Servlet implementation class CreateQuestion
 */
@WebServlet("/Formateur/createQuestion")
public class CreateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW = "/Former/ManagementQuestion/CreateQuestion.jsp";   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Theme> lstTheme = new ArrayList<Theme>();
		
		try {
			lstTheme = ThemeDAO.GetAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lstTheme", lstTheme);
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Question question = new Question();
		
		question.setStatement(request.getParameter("statement"));
		question.setMedia(Integer.parseInt(request.getParameter("media")));
		question.setPoints(Integer.parseInt(request.getParameter("points")));
		
		Theme theme = new Theme();
		theme.setId(Integer.parseInt(request.getParameter("theme")));	
		
		try {
			theme = ThemeDAO.SearchByID(theme.getId());
			
			if(theme != null)
				question.setTheme(theme);
			else{
				throw new Exception( "Le theme n'existe pas");
			}
			
			QuestionDAO.Insert(question);
			
		} catch (SQLException e1) {			
			e1.printStackTrace();
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		
		List<Theme> lstTheme = new ArrayList<Theme>();
		
		try {
			lstTheme = ThemeDAO.GetAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lstTheme", lstTheme);
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}
	
}
