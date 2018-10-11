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
 * Servlet implementation class Exam
 */
@WebServlet("/Candidat/Exam")
public class ExamDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamDetail() {
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
			List<Question> questions = new ArrayList<Question>();
			List<ExamQuestion> examQuestions = new ArrayList<ExamQuestion>();
			examQuestions = ExamQuestionDAO.SearchByExam(exam.getId());

			
			if(examQuestions.isEmpty()) {
				questions = EpreuveDAO.GenerateQuestion(exam.getId());
				// TODO questions NULL si pas assez en base
				EpreuveDAO.InsertDrawQuestion(questions, exam);
			} else {
				//TODO return already draw question for this exam.id
				request.setAttribute("examQuestions", examQuestions);
			}
			

			request.setAttribute("questions", questions);
			request.setAttribute("exam", exam);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/Candidate/ManageTest/Exam.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
