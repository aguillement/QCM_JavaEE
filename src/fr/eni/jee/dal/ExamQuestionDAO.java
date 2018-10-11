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
	private final static String HAS_GENERATED_QUESTIONS = "SELECT idQuestion, idExam, orderNumber, isMarked FROM DRAW_QUESTION WHERE idExam = ?";
	
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

}

	