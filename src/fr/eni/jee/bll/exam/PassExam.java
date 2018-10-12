package fr.eni.jee.bll.exam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.Question;
import fr.eni.jee.dal.EpreuveDAO;
import fr.eni.jee.dal.ExamQuestionDAO;

/**
 * Servlet implementation class PassExam
 */
@WebServlet("/Candidat/PassExam")
public class PassExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int examID = Integer.parseInt(request.getParameter("id"));
		try {
			Exam exam = EpreuveDAO.SearchByID(examID);
			
			/**
			 * Récupération des questions
			 */
			List<Question> questions = new ArrayList<Question>();
			List<ExamQuestion> examQuestions = new ArrayList<ExamQuestion>();
			examQuestions = ExamQuestionDAO.SearchByExam(exam.getId());
 			
			if(examQuestions.isEmpty()) {
				questions = EpreuveDAO.GenerateQuestion(exam);
				EpreuveDAO.InsertDrawQuestion(questions, exam);
				request.setAttribute("questions", questions);
			} else {
				request.setAttribute("examQuestions", examQuestions);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/Candidate/ManageTest/PassExam.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
