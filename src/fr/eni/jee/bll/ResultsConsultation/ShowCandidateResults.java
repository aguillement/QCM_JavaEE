package fr.eni.jee.bll.ResultsConsultation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.ResultExamDTO;
import fr.eni.jee.bo.User;
import fr.eni.jee.dal.EpreuveDAO;

/**
 * Servlet implementation class ShowCandidateResults
 */
@WebServlet("/Candidat/ShowCandidateResults")
public class ShowCandidateResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VIEW = "/Candidate/ResultsConsultation/CandidateResults.jsp";   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCandidateResults() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("sessionUser");
		if(user != null && user.getProfile().getId() == 20){
			
			List<ResultExamDTO> lstResultExamDTO = new ArrayList<ResultExamDTO>(); 
			
			try {
				lstResultExamDTO = EpreuveDAO.GetAllResultExam(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("lstResultExamDTO", lstResultExamDTO);
		}
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
	}

}
