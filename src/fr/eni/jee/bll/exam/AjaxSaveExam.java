package fr.eni.jee.bll.exam;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.dal.ExamQuestionDAO;

/**
 * Servlet implementation class AjaxSaveExam
 */
@WebServlet("/Candidate/AjaxSaveExam")
public class AjaxSaveExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxSaveExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int examID = Integer.valueOf(request.getParameter("examID"));
		
		try {
			ExamQuestionDAO.UpdateTimeSpend(examID);
			
			if(request.getParameter("finished") != null) {
				System.out.println(request.getParameter("finished"));
				ExamQuestionDAO.UpdateState(examID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
