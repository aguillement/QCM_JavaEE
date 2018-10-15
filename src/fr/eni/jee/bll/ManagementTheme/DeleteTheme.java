package fr.eni.jee.bll.ManagementTheme;

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
 * Servlet implementation class DeleteTheme
 */
@WebServlet("/Formateur/deleteTheme")
public class DeleteTheme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Former/ManagementQuestion/ListQuestion.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTheme() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Theme theme = new Theme();
		theme.setId(Integer.parseInt(request.getParameter("id")));

		try {
			ThemeDAO.Delete(theme);
		} catch (SQLException e) {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

}
