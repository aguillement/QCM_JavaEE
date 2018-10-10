package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.Question;
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
	private static final String SEARCH_BY_USER = "SELECT id, startDate, endDate, timeSpent, state, score, level, idTest, idUser FROM EXAM WHERE idUser=?";
	private static final String SEARCH_BY_ID = "SELECT idExam, startDate, endDate, timeSpend, state, score, level, idTest, idUser FROM EXAM WHERE idExam=?";
	private static final String GENERATE_QUESTIONS = "EXEC PROC_GENERATE_QUESTIONS ?";
	
	private static final String INSERT_QUESTION_TIRAGE = "INSERT INTO DRAW_QUESTION(isMarked, idQuestion, OrderNumber, idExam) VALUES (?, ?, ?, ?)";
	
	/**
	 * Search all exams for userID
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public static List<Exam> SearchByUser(int userID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Exam exam = null;
		List<Exam> listEpreuves = new ArrayList<Exam>();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_USER);
			rqt.setInt(1, userID);
			rs=rqt.executeQuery();

			while (rs.next()){
				user = UserDAO.SearchById(rs.getInt("idUser"));
				exam = new Exam();
				exam.setId(rs.getInt("idExam"));
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
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return listEpreuves;
	}
	
	/**
	 * Search epreuve by id
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public static Exam SearchByID(int examID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Exam exam = new Exam();
		
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, examID);
			rs=rqt.executeQuery();

			if(rs.next()){				
				user = UserDAO.SearchById(rs.getInt("idUser"));
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
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return exam;
	}
	
	/**
	 * Call stored procedure to generate questions
	 * @param idEpreuve
	 * @return
	 * @throws SQLException
	 */
	private static List<Question> GenerateQuestion(int idExam) throws SQLException{
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Question> questionsList = new ArrayList<Question>();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(GENERATE_QUESTIONS);
			rqt.setInt(1, idExam);
			rs=rqt.executeQuery();

			while (rs.next()){
				theme = ThemeDAO.SearchByID(rs.getInt("idTheme"));
				Question question = null;
				question.setId(rs.getInt("id"));
				question.setStatement(rs.getString("enonce"));
				question.setMedia(rs.getInt("media"));
				question.setPoints(rs.getInt("points"));
				question.setTheme(theme);
				
				questionsList.add(question);
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return questionsList;
	}
	
	public static void InsertDrawQuestion(List<Question> questions, int idExam) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccessDB.getConnection();
			 
			cnx.setAutoCommit(false);
			int orderQuestionCounter = 0;
			for(Question question : questions) {
				orderQuestionCounter++;
				ExamQuestion questionExam = new ExamQuestion(false, question.getId(), orderQuestionCounter, idExam);
				rqt = cnx.prepareStatement(INSERT_QUESTION_TIRAGE);
				rqt.setBoolean(1, questionExam.getIsMarked());
				rqt.setInt(2, questionExam.getIdQuestion());
				rqt.setInt(3, questionExam.getOrderNumber());
				rqt.setInt(4, questionExam.getIdExam());
				rqt.executeUpdate();
			}

			
			cnx.commit();			
		} catch (SQLException sqle){
						
			if (cnx != null) {
				cnx.rollback();
			}
						
			throw sqle;
		} finally {
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
}
