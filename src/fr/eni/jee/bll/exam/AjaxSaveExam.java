package fr.eni.jee.bll.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.ExamQuestion;
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
			if(request.getParameter("updateTimer") != null) {
				ExamQuestionDAO.UpdateTimeSpend(examID);
			}
			
			if(request.getParameter("finished") != null) {
				ExamQuestionDAO.UpdateState(examID);
			}
			if(request.getParameter("questionID") != null) {
				ExamQuestionDAO.MarkQuestion(Integer.valueOf(request.getParameter("questionID")), examID);
			}

			if(request.getParameter("getDuration") != null) {
			    String jsonData = Integer.toString(ExamQuestionDAO.GetDuration(examID));  

			    response.setContentType("application/json");
			    PrintWriter out = response.getWriter();
			    out.println(jsonData) ; 
			    out.close();
			}
			//
			List<ExamQuestion> examQuestions = ExamQuestionDAO.SearchByExam(examID);
			request.getSession().setAttribute("examQuestions", examQuestions);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
