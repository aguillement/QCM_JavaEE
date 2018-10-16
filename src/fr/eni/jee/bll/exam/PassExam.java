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
import javax.servlet.http.HttpSession;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.ExamAnswer;
import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.Proposition;
import fr.eni.jee.bo.Question;
import fr.eni.jee.dal.EpreuveDAO;
import fr.eni.jee.dal.ExamAnswerDAO;
import fr.eni.jee.dal.ExamQuestionDAO;
import fr.eni.jee.dal.PropositionDAO;
import fr.eni.jee.dal.QuestionDAO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		redirect(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		redirect(request, response);
	}

	/**
	 * Send data to the database
	 * 
	 * @param request
	 */
	protected void sendResponses(HttpServletRequest request) {
		String[] values = request.getParameterValues("responses");
		// V�rification de la r�ponse � la question
		if (values != null) {
			int questionID = Integer.parseInt(request.getParameter("question_id"));
			HttpSession session = request.getSession();
			ExamAnswerDAO examAnswerDAO = new ExamAnswerDAO();
			Exam currentExam = (Exam) session.getAttribute("exam");
			// r�cup�ration des r�ponses dans la base
			List<ExamAnswer> listAnswer = new ArrayList<ExamAnswer>();
			try {
				listAnswer = examAnswerDAO.SearchByQuestionAndExam(currentExam.getId(), questionID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error", "Erreur lors de la r�cup�ration des anciennes r�ponses");
			}
			// suppression des r�ponses dans la base
			try {
				for (ExamAnswer answer : listAnswer) {
					examAnswerDAO.Delete(answer);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("error", "Erreur lors de la suppression des anciennes r�ponses");
			}
			// envoi des r�ponses � la base
			for (String value : values) {
				try {
					PropositionDAO propositionDAO = new PropositionDAO();
					QuestionDAO questionDAO = new QuestionDAO();
					Proposition proposition = propositionDAO.SearchById(Integer.parseInt(value));
					Question question = questionDAO.SearchByID(questionID);

					ExamAnswer answer = new ExamAnswer();
					answer.setExam(currentExam);
					answer.setQuestion(question);
					answer.setProposition(proposition);
					examAnswerDAO.Insert(answer);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("error", "Erreur sur le num�ro de la proposition choisie");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("error", "Impossible d'enregistrer les r�ponses");
				}

			}
		}

	}

	/**
	 * Redirect to the next question
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void redirect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int examID = -1;
		int questionID = 1;
		boolean examExist = false;

		if (request.getParameter("idQuestion") != null) {
			questionID = Integer.parseInt(request.getParameter("idQuestion"));
		}

		// Check if the session has an exam
		if (session.getAttribute("exam") == null) {
			// Set the exam of the session
			examID = Integer.parseInt(request.getParameter("id"));
			Exam exam = null;
			try {
				exam = EpreuveDAO.SearchByID(examID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (exam.getId() != 0) {
				session.setAttribute("exam", exam);
				examExist = true;
			}
		}
		else{
			examExist = true;
		}

		if (examExist) {
			try {
				Exam currentExam = (Exam) session.getAttribute("exam");

				/**
				 * R�cup�ration des questions
				 */
				if (session.getAttribute("examQuestions") == null) {
					List<Question> questions = new ArrayList<Question>();
					List<ExamQuestion> examQuestions = new ArrayList<ExamQuestion>();
					examQuestions = ExamQuestionDAO.SearchByExam(currentExam.getId());

					if (examQuestions.isEmpty()) {
						questions = EpreuveDAO.GenerateQuestion(currentExam);
						EpreuveDAO.InsertDrawQuestion(questions, currentExam);
						examQuestions = ExamQuestionDAO.SearchByExam(currentExam.getId());
					}
					session.setAttribute("examQuestions", examQuestions);
				}
				// Check if the questionID is in the list of question
				List<ExamQuestion> examQuestions = (List<ExamQuestion>) session.getAttribute("examQuestions");
				if (questionID > examQuestions.size()) {
					questionID = 1;
				}

				// Send data to the JSP file
				request.setAttribute("idQuestion", questionID);
				request.setAttribute("idExam", currentExam.getId());
				request.setAttribute("currentQuestion", getCurrentQuestion(questionID, session));
				request.setAttribute("currentPropositions", getCurrentPropositions(request));
				request.setAttribute("answers", getAnswers(request));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				request.setAttribute("error", "Impossible de charger les r�ponses");
			}

			sendResponses(request);
			
		}
		else{
			request.setAttribute("error", "Le test que vous rechercher n'existe pas ou n'est plus accessible.");
		}
		
		this.getServletContext().getRequestDispatcher("/Candidate/ManageTest/PassExam.jsp").forward(request,
				response);

	}

	/**
	 * Return the current question
	 * 
	 * @param numQuestion
	 * @param session
	 * @return
	 */
	protected Question getCurrentQuestion(int numQuestion, HttpSession session) {
		Question currentQuestion = null;
		List<ExamQuestion> examQuestions = (List<ExamQuestion>) session.getAttribute("examQuestions");
		for (ExamQuestion question : examQuestions) {
			if (question.getOrderNumber() == numQuestion) {
				currentQuestion = question.getQuestion();
			}
		}
		return currentQuestion;
	}

	/**
	 * Return the list of proposition for the current question
	 * 
	 * @param request
	 * @return
	 */
	protected List<Proposition> getCurrentPropositions(HttpServletRequest request) {
		PropositionDAO propositionDAO = new PropositionDAO();
		Question question = (Question) request.getAttribute("currentQuestion");
		List<Proposition> allPropositions = null;
		try {
			allPropositions = propositionDAO.SearchByQuestion(question.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allPropositions;
	}

	/**
	 * Return the answers for one question
	 * 
	 * @param request
	 * @return
	 */
	protected List<Proposition> getAnswers(HttpServletRequest request) {
		PropositionDAO propositionDAO = new PropositionDAO();
		Question question = (Question) request.getAttribute("currentQuestion");
		List<Proposition> allAnswers = null;
		int idExam = Integer.parseInt(request.getAttribute("idExam").toString());
		try {
			allAnswers = propositionDAO.SearchByQuestionAndExam(question.getId(), idExam);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allAnswers;
	}
}
