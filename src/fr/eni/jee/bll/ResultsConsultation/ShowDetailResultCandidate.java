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
 * Servlet implementation class ShowDetailResultCandidate
 */
@WebServlet("/Responsable/ShowDetailResultCandidate")
public class ShowDetailResultCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/Manager/ManageResultsCandidate/DetailResultCandidate.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetailResultCandidate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idUser = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		user.setId(idUser);
		
		if(user != null){
			
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
