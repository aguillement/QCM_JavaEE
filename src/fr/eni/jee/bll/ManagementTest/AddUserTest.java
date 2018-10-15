package fr.eni.jee.bll.ManagementTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.Promotion;
import fr.eni.jee.bo.Test;
import fr.eni.jee.dal.PromotionDAO;
import fr.eni.jee.dal.TestDAO;

/**
 * Servlet implementation class AddUserTest
 */
@WebServlet("/Responsable/test/ajouter")
public class AddUserTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Manager/ManageTest/TestDetail.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int testID = Integer.valueOf((String) request.getParameter("id"));
		try {
			Test test = TestDAO.SearchByID(testID);
			request.setAttribute("test", test);
			
			List<Promotion> promos = PromotionDAO.GetAll(); 
			request.setAttribute("promos", promos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
