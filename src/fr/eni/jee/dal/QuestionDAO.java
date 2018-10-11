package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.Question;
import fr.eni.jee.bo.Theme;
import fr.eni.jee.util.AccessDB;

public class QuestionDAO {

	private static final String INSERT = "INSERT INTO QUESTION (statement, media, points, idTheme) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL = "SELECT id, statement, media, points, idTheme FROM QUESTION";
	private static final String SEARCH_BY_ID = "SELECT id, statement, media, points, idTheme FROM QUESTION WHERE id=?";
	
	
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
	
	public static List<Question> GetAll() throws SQLException{
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Question question = null;
		List<Question> lstQuestion = new ArrayList<Question>();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(GET_ALL);
			rs=rqt.executeQuery();

			while (rs.next()){
				question = new Question();
								
				question.setId(rs.getInt("id"));				
				question.setStatement(rs.getString("statement"));
				question.setMedia(rs.getInt("media"));
				question.setPoints(rs.getInt("points"));
				
				Theme theme = new Theme();
				theme = ThemeDAO.SearchByID(rs.getInt("idTheme"));				
				question.setTheme(theme);				
				
				lstQuestion.add(question);
			}			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}		
		
		return lstQuestion;
	}
	
	
	public static Question SearchByID(int questionID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		Question question = new Question();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, questionID);
			rs=rqt.executeQuery();

			while(rs.next()){
				question.setId(rs.getInt("id"));
				question.setMedia(rs.getInt("media"));
				question.setPoints(rs.getInt("points"));
				question.setStatement(rs.getString("statement"));
				question.setTheme(ThemeDAO.SearchByID(rs.getInt("idTheme")));
			}
		
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return question;
	}
}
