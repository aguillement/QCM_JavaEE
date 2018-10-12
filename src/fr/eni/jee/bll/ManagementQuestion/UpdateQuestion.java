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

import fr.eni.jee.bo.Theme;
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
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

}
