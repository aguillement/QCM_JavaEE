package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.Question;
import fr.eni.jee.bo.User;
import fr.eni.jee.util.AccessDB;

public class ExamQuestionDAO {
	
	private final static String INSERT = "INSERT INTO DRAW_QUESTION (isMarked, idQuestion, orderNumber, idExam) values (?,?,?,?)";
	private final static String HAS_GENERATED_QUESTIONS = "SELECT idQuestion, idExam, orderNumber, isMarked FROM DRAW_QUESTION WHERE idExam = ? ORDER BY orderNumber";
	private final static String UPDATE_TIME_SPEND = "UPDATE EXAM SET timeSpent = timeSpent + 1, state='EC' WHERE id=?";
	private final static String UPDATE_STATE = "UPDATE EXAM SET state = 'T' WHERE id=?";
	private final static String MARK_QUESTION = "UPDATE DRAW_QUESTION SET isMarked=isMarked^1 WHERE idQuestion=? and idExam=?";
	private final static String GET_DURATION = "SELECT duration - timeSpent AS 'duration' FROM EXAM INNER JOIN TEST ON EXAM.idTest = TEST.id WHERE EXAM.id=?";
	
	public static ExamQuestion Insert(ExamQuestion question) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccessDB.getConnection();
			 
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareStatement(INSERT);
			rqt.setBoolean(1, question.getIsMarked());
			rqt.setInt(2, question.getQuestion().getId());
			rqt.setInt(3, question.getOrderNumber());
			rqt.setInt(4, question.getExam().getId());
			rqt.executeUpdate();
			
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
		
		return question;
	}
	
	public static int GetDuration(int examID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
 		int duration = 0;
 		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(GET_DURATION);
			rqt.setInt(1, examID);
			rs=rqt.executeQuery();
 			while(rs.next()){
				duration = rs.getInt("duration");
			}
		
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return duration;
	}
	
	public static List<ExamQuestion> SearchByExam(int examID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
 		List<ExamQuestion> questionsList = new ArrayList<ExamQuestion>();
 		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(HAS_GENERATED_QUESTIONS);
			rqt.setInt(1, examID);
			rs=rqt.executeQuery();
 			while(rs.next()){
				ExamQuestion examQuestion = new ExamQuestion();
				examQuestion.setExam(EpreuveDAO.SearchByID(rs.getInt("idExam")));
				examQuestion.setQuestion(QuestionDAO.SearchByID(rs.getInt("idQuestion")));
				examQuestion.setOrderNumber(rs.getInt("orderNumber"));
				examQuestion.setIsMarked(rs.getBoolean("isMarked"));
				questionsList.add(examQuestion);
			}
		
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return questionsList;
	}
	
	
	public static void UpdateTimeSpend(int examID) throws SQLException {

		Connection cnx = null;
		PreparedStatement rqt = null;

		try {
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(UPDATE_TIME_SPEND);
			rqt.setInt(1, examID);

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
	
	public static void UpdateState(int examID) throws SQLException {

		Connection cnx = null;
		PreparedStatement rqt = null;

		try {
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(UPDATE_STATE);
			rqt.setInt(1, examID);

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
	
	public static void MarkQuestion(int questionID, int examID) throws SQLException {

		Connection cnx = null;
		PreparedStatement rqt = null;

		try {
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(MARK_QUESTION);
			rqt.setInt(1, questionID);
			rqt.setInt(2, examID);

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
}
