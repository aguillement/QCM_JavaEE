package fr.eni.jee.bll.ResultsConsultation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.User;

/**
 * Servlet implementation class ShowListResultCandidate
 */
@WebServlet("/ShowListResultCandidate")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the list off candidate
		List<User> lstUserCandidate = new ArrayList<User>();
		
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

}
