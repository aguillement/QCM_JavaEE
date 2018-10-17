package fr.eni.jee.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.Question;
import fr.eni.jee.bo.ResultExamDTO;
import fr.eni.jee.bo.Test;
import fr.eni.jee.bo.Theme;
import fr.eni.jee.bo.User;
import fr.eni.jee.util.AccessDB;

public class EpreuveDAO {

	private static Test test = null;
	private static User user = null;
	private static Theme theme = null;

	/**
	 * Queries
	 */
	private static final String SEARCH_BY_USER = "SELECT id, startDate, endDate, timeSpent, state, score, level, idTest, idUsers FROM EXAM WHERE idUsers=? AND state <> 'T' AND DATEDIFF(second,GETDATE(),endDate) > 0";
	private static final String SEARCH_BY_ID = "SELECT id, startDate, endDate, timeSpent, state, score, level, idTest, idUsers FROM EXAM WHERE id=? AND state <> 'T' AND DATEDIFF(second,GETDATE(),endDate) > 0";
	private static final String SEARCH_BY_ID_FINISH = "SELECT id, startDate, endDate, timeSpent, state, score, level, idTest, idUsers FROM EXAM WHERE id=?";
	private static final String GENERATE_QUESTIONS = "EXEC PROC_GENERATE_QUESTIONSV2 ?";
	private static final String FT_GET_RESULT_EXAM = "SELECT * FROM FT_GET_RESULT_EXAM(?)";
	private static final String INSERT_QUESTION_TIRAGE = "INSERT INTO DRAW_QUESTION(isMarked, idQuestion, OrderNumber, idExam) VALUES (?, ?, ?, ?)";
	private static final String INSERT = "INSERT INTO EXAM(startDate, endDate, state, idTest, idUsers) VALUES(?, ?, ?, ?, ?)";
	private static final String FINISH_EXAM = "UPDATE EXAM SET state = 'T' WHERE id = ? AND idUsers = ?";

	
	public static void FinishTest(Exam exam, int userID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;

		try {
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(FINISH_EXAM);
			rqt.setInt(1, exam.getId());
			rqt.setInt(2, userID);

			rqt.executeUpdate();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (rqt != null) {
				rqt.close();
			}

			if (cnx != null) {
				cnx.close();
			}

		}
	}
	
	/**
	 * Search all exams for userID
	 * 
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public static List<Exam> SearchByUser(int userID) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Exam exam = null;
		List<Exam> listEpreuves = new ArrayList<Exam>();

		try {
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_USER);
			rqt.setInt(1, userID);
			rs = rqt.executeQuery();

			while (rs.next()) {
				test = TestDAO.SearchByID(rs.getInt("idTest"));
				user = UserDAO.SearchById(rs.getInt("id"));
				exam = new Exam();
				exam.setId(rs.getInt("id"));
				exam.setStartDate(rs.getTimestamp("startDate"));
				exam.setEndDate(rs.getTimestamp("endDate"));
				exam.setTimeSpent(rs.getInt("timeSpent"));
				exam.setState(rs.getString("state"));
				exam.setScore(rs.getFloat("score"));
				exam.setLevel(rs.getString("level"));
				exam.setTest(test);
				exam.setUser(user);

				// Add this epreuve to list and go to next.
				listEpreuves.add(exam);
			}

		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		return listEpreuves;
	}

	/**
	 * Search epreuve by id
	 * 
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public static Exam SearchByID(int examID) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Exam exam = new Exam();

		try {
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, examID);
			rs = rqt.executeQuery();

			if (rs.next()) {
				test = TestDAO.SearchByID(rs.getInt("idTest"));
				user = UserDAO.SearchById(rs.getInt("idUsers"));
				exam.setId(rs.getInt("id"));
				exam.setStartDate(rs.getTimestamp("startDate"));
				exam.setEndDate(rs.getTimestamp("endDate"));
				exam.setTimeSpent(rs.getInt("timeSpent"));
				exam.setState(rs.getString("state"));
				exam.setScore(rs.getFloat("score"));
				exam.setLevel(rs.getString("level"));
				exam.setTest(test);
				exam.setUser(user);
			}

		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		return exam;
	}
	
	public static Exam SearchExamIsFinish(int examID) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Exam exam = new Exam();

		try {
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID_FINISH);
			rqt.setInt(1, examID);
			rs = rqt.executeQuery();

			if (rs.next()) {
				test = TestDAO.SearchByID(rs.getInt("idTest"));
				user = UserDAO.SearchById(rs.getInt("idUsers"));
				exam.setId(rs.getInt("id"));
				exam.setStartDate(rs.getTimestamp("startDate"));
				exam.setEndDate(rs.getTimestamp("endDate"));
				exam.setTimeSpent(rs.getInt("timeSpent"));
				exam.setState(rs.getString("state"));
				exam.setScore(rs.getFloat("score"));
				exam.setLevel(rs.getString("level"));
				exam.setTest(test);
				exam.setUser(user);
			}

		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		return exam;
	}

	/**
	 * Call stored procedure to generate questions
	 * 
	 * @param idEpreuve
	 * @return
	 * @throws SQLException
	 */
	public static List<Question> GenerateQuestion(Exam exam) throws SQLException {

		Connection cnx = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		List<Question> questionsList = new ArrayList<Question>();

		try {
			cnx = AccessDB.getConnection();
			callableStatement = cnx.prepareCall("{call PROC_GENERATE_QUESTIONSV2(?)}");
			callableStatement.setInt(1, exam.getTest().getId());
			rs = callableStatement.executeQuery();

			while (rs.next()) {
				theme = ThemeDAO.SearchByID(rs.getInt("idTheme"));
				Question question = new Question();
				question.setId(rs.getInt("id"));
				question.setStatement(rs.getString("statement"));
				question.setMedia(rs.getInt("media"));
				question.setPoints(rs.getInt("points"));
				question.setTheme(theme);

				questionsList.add(question);
			}

		} finally {
			if (callableStatement != null)
				callableStatement.close();
			if (cnx != null)
				cnx.close();
		}
		return questionsList;
	}

	public static void InsertDrawQuestion(List<Question> questions, Exam exam) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = AccessDB.getConnection();

			cnx.setAutoCommit(false);
			int orderQuestionCounter = 0;
			for (Question question : questions) {
				orderQuestionCounter++;
				ExamQuestion questionExam = new ExamQuestion(false, question, orderQuestionCounter, exam);
				rqt = cnx.prepareStatement(INSERT_QUESTION_TIRAGE);
				rqt.setBoolean(1, questionExam.getIsMarked());
				rqt.setInt(2, questionExam.getQuestion().getId());
				rqt.setInt(3, questionExam.getOrderNumber());
				rqt.setInt(4, questionExam.getExam().getId());
				rqt.executeUpdate();
			}

			cnx.commit();
		} catch (SQLException sqle) {

			if (cnx != null) {
				cnx.rollback();
			}

			throw sqle;
		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}

	public static void Insert(String startDate, String endDate, String state, int testID, int userID)
			throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = AccessDB.getConnection();

			cnx.setAutoCommit(false);

			rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setTimestamp(1, Timestamp.valueOf(startDate));
			rqt.setTimestamp(2, Timestamp.valueOf(endDate));
			rqt.setString(3, state);
			rqt.setInt(4, testID);
			rqt.setInt(5, userID);

			rqt.executeUpdate();
			cnx.commit();

		} catch (SQLException sqle) {
			if (cnx != null) {
				cnx.rollback();
			}

			throw sqle;
		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
	}

	public static ResultExamDTO GetResultExam(Exam exam) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ResultExamDTO resultExamDTO = null;
		
		try {
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(FT_GET_RESULT_EXAM);
			rqt.setInt(1, exam.getId());
			rs = rqt.executeQuery();

			if (rs.next()) {
				resultExamDTO = new ResultExamDTO();
				resultExamDTO.setResult(rs.getString("result"));
				resultExamDTO.setNbQuestion(rs.getInt("nbQuestion"));
				resultExamDTO.setIdExam(rs.getInt("idExam"));
				resultExamDTO.setLabel(rs.getString("label"));
				resultExamDTO.setNbRightQuestion(rs.getInt("nbRightQuestion"));
				resultExamDTO.setNbAnsweredQuestion(rs.getInt("nbAnsweredQuestion"));
			}

		} finally {
			if (rqt != null)
				rqt.close();
			if (cnx != null)
				cnx.close();
		}
		return resultExamDTO;
	}
	
	public static List<ResultExamDTO> GetAllResultExam(User user) throws SQLException{
		
		List<ResultExamDTO> lstResultExamDTO = new ArrayList<ResultExamDTO>();
		List<Exam> lstExam = new ArrayList<Exam>();
		
		lstExam = SearchByUser(user.getId());
		
		for(Exam exam: lstExam){
			
			ResultExamDTO resultExamDTO = new ResultExamDTO();
			resultExamDTO = GetResultExam(exam);
			
			if(resultExamDTO != null)
				lstResultExamDTO.add(resultExamDTO);
		}
		
		return lstResultExamDTO;
	}
}
