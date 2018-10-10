package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.jee.bo.Question;
import fr.eni.jee.util.AccessDB;

public class QuestionDAO {

	private static final String INSERT = "INSERT INTO QUESTION (statement, media, points, idTheme) VALUES (?, ?, ?, ?)";
	
	public static Question Insert(Question question) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccessDB.getConnection();
			 
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);			
			rqt.setString(1, question.getStatement());
			rqt.setInt(2, question.getMedia());
			rqt.setInt(3, question.getPoints());
			rqt.setInt(4, question.getTheme().getId());
			rqt.executeUpdate();
			ResultSet key = rqt.getGeneratedKeys();			
			key.next();
			question.setId(key.getInt(1));
			
			cnx.commit();
			
			key.close();
			
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
