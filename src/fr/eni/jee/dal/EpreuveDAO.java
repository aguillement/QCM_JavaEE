package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Epreuve;
import fr.eni.jee.bo.Question;
import fr.eni.jee.bo.QuestionEpreuve;
import fr.eni.jee.bo.Test;
import fr.eni.jee.bo.Theme;
import fr.eni.jee.bo.User;
import fr.eni.jee.util.AccesBase;

public class EpreuveDAO {
	
	private static Test test = null;
	private static User user = null;
	private static Theme theme = null;
	
	/**
	 * Queries
	 */
	private static final String SEARCH_BY_USER = "SELECT idEpreuve, dateDebutValidite, dateFinValidite, tempsEcoule, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur FROM EPREUVE WHERE user=?";
	private static final String SEARCH_BY_ID = "SELECT idEpreuve, dateDebutValidite, dateFinValidite, tempsEcoule, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur FROM EPREUVE WHERE idEpreuve=?";
	private static final String GENERATE_QUESTIONS = "EXEC PROC_GENERATE_QUESTIONS ?";
	
	private static final String INSERT_QUESTION_TIRAGE = "INSERT INTO QUESTION_TIRAGE(estMarquee, idQuestion, numordre, idEpreuve) VALUES (?, ?, ?, ?)";
	
	/**
	 * Search all epreuves for userID
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public static List<Epreuve> SearchByUser(int userID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Epreuve epreuve = null;
		List<Epreuve> listEpreuves = new ArrayList<Epreuve>();

		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_USER);
			rqt.setInt(1, userID);
			rs=rqt.executeQuery();

			while (rs.next()){
				test = TestDAO.SearchById(rs.getInt("idTest"));
				user = UserDAO.SearchByidUtilisateur(rs.getInt("idUtilisateur"));
				epreuve = new Epreuve();
				epreuve.setIdEpreuve(rs.getInt("idEpreuve"));
				epreuve.setDateDebutValidite(rs.getTimestamp("dateDebutValidite"));
				epreuve.setDateFinValidite(rs.getTimestamp("dateFinValidite"));
				epreuve.setTempsEcoule(rs.getInt("tempsEcoule"));
				epreuve.setEtat(rs.getString("etat"));
				epreuve.setNote_obtenue(rs.getFloat("note_obtenue"));
				epreuve.setNiveau_obtenu(rs.getString("niveau_obtenu"));
				epreuve.setTest(test);
				epreuve.setUser(user);
				
				// Add this epreuve to list and go to next.
				listEpreuves.add(epreuve);
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
	public static Epreuve SearchByID(int epreuveID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Epreuve epreuve = null;
		
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, epreuveID);
			rs=rqt.executeQuery();

			if(rs.next()){
				test = TestDAO.SearchById(rs.getInt("idTest"));
				user = UserDAO.SearchByidUtilisateur(rs.getInt("idUtilisateur"));
				epreuve = new Epreuve();
				epreuve.setIdEpreuve(rs.getInt("idEpreuve"));
				epreuve.setDateDebutValidite(rs.getTimestamp("dateDebutValidite"));
				epreuve.setDateFinValidite(rs.getTimestamp("dateFinValidite"));
				epreuve.setTempsEcoule(rs.getInt("tempsEcoule"));
				epreuve.setEtat(rs.getString("etat"));
				epreuve.setNote_obtenue(rs.getFloat("note_obtenue"));
				epreuve.setNiveau_obtenu(rs.getString("niveau_obtenu"));
				epreuve.setTest(test);
				epreuve.setUser(user);
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return epreuve;
	}
	
	/**
	 * Call stored procedure to generate questions
	 * @param idEpreuve
	 * @return
	 * @throws SQLException
	 */
	private static List<Question> GenererQuestion(int idEpreuve) throws SQLException{
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Question> listQuestions = new ArrayList<Question>();

		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(GENERATE_QUESTIONS);
			rqt.setInt(1, idEpreuve);
			rs=rqt.executeQuery();

			while (rs.next()){
				theme = ThemeDAO.SearchByID(rs.getInt("idTheme"));
				Question question = null;
				question.setIdQuestion(rs.getInt("idQuestion"));
				question.setEnonce(rs.getString("enonce"));
				question.setMedia(rs.getString("media"));
				question.setPoints(rs.getInt("points"));
				question.setTheme(theme);
				
				listQuestions.add(question);
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return listQuestions;
	}
	
	public static void InsertQuestionTirage(List<Question> questions, int idEpreuve) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccesBase.getConnection();
			 
			cnx.setAutoCommit(false);
			int compteurOrdreQuestion = 0;
			for(Question question : questions) {
				compteurOrdreQuestion++;
				QuestionEpreuve questionEpreuve = new QuestionEpreuve(false, question.getIdQuestion(), compteurOrdreQuestion, idEpreuve);
				rqt = cnx.prepareStatement(INSERT_QUESTION_TIRAGE);
				rqt.setBoolean(1, questionEpreuve.getEstMarquee());
				rqt.setInt(2, questionEpreuve.getIdQuestion());
				rqt.setInt(3, questionEpreuve.getNumOrdre());
				rqt.setInt(4, questionEpreuve.getIdEpreuve());
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
