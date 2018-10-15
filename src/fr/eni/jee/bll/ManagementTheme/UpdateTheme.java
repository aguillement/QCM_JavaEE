package fr.eni.jee.bll.ManagementTheme;

import java.io.IOException;
import java.sql.SQLException;

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
		
		Theme theme = new Theme();
		Integer idThemeUpdate = Integer.parseInt(request.getParameter("id"));
		
		if(idThemeUpdate != null){
			try {
				theme = ThemeDAO.SearchByID(idThemeUpdate);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("theme", theme);	
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		Theme theme = new Theme();	
		theme.setId(Integer.parseInt(request.getParameter("idTheme")));
		theme.setLabel(request.getParameter("label"));		

		try {
			ThemeDAO.Update(theme);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

}
