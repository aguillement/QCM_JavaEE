package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.User;
import fr.eni.jee.util.AccessDB;

public class ExamQuestionDAO {
	
	private final static String INSERT = "INSERT INTO DRAW_QUESTION (isMarked, idQuestion, orderNumber, idExam) values (?,?,?,?)";

	
	public static ExamQuestion Insert(ExamQuestion question) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccessDB.getConnection();
			 
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareStatement(INSERT);
			rqt.setBoolean(1, question.getIsMarked());
			rqt.setInt(2, question.getIdQuestion());
			rqt.setInt(3, question.getOrderNumber());
			rqt.setInt(4, question.getIdExam());
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
}
