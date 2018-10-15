package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.ExamAnswer;
import fr.eni.jee.bo.Proposition;
import fr.eni.jee.bo.Question;
import fr.eni.jee.util.AccessDB;

public class ExamAnswerDAO {
	private final static String SELECT_ALL_FOR_EXAM_QUESTION = "SELECT idProposition, idQuestion, idExam FROM DRAW_ANSWER WHERE idQuestion = ? AND idExam = ?";
	private final static String INSERT = "INSERT INTO DRAW_ANSWER (idProposition, idQuestion, idExam) VALUES (?,?,?)";
	private final static String DELETE = "DELETE FROM DRAW_ANSWER WHERE idQuestion = ? AND idExam = ?";
	
	public static List<ExamAnswer> SearchByQuestionAndExam(int idExam, int idQuestion) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		ExamAnswer answer = null;
		List<ExamAnswer> listAnswers = new ArrayList<ExamAnswer>();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SELECT_ALL_FOR_EXAM_QUESTION);
			rqt.setInt(1, idQuestion);
			rqt.setInt(2, idExam);
			rs=rqt.executeQuery();

			while (rs.next()){
				Exam exam = EpreuveDAO.SearchByID(rs.getInt("idExam"));
				Question question = QuestionDAO.SearchByID(rs.getInt("idQuestion"));
				Proposition proposition = PropositionDAO.SearchById(rs.getInt("idProposition"));
				answer = new ExamAnswer();
				answer.setExam(exam);
				answer.setQuestion(question);
				answer.setProposition(proposition);
				
				// Add this epreuve to list and go to next.
				listAnswers.add(answer);
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return listAnswers;
	}
	
	public static ExamAnswer Insert(ExamAnswer answer) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccessDB.getConnection();
			 
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareStatement(INSERT);
			rqt.setInt(1, answer.getProposition().getId());
			rqt.setInt(2, answer.getQuestion().getId());
			rqt.setInt(3, answer.getExam().getId());
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
		
		return answer;
	}
	
	public static void Delete(ExamAnswer answer) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccessDB.getConnection();
			 
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareStatement(DELETE);
			rqt.setInt(1, answer.getQuestion().getId());
			rqt.setInt(2, answer.getExam().getId());
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
	}
}
