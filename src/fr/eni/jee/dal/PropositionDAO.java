package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Proposition;
import fr.eni.jee.bo.Question;
import fr.eni.jee.util.AccessDB;

public class PropositionDAO {
	private final static String SELECT_ALL_FOR_QUESTION = "SELECT id,statement, isTrue, idQuestion FROM PROPOSITION WHERE idQuestion = ?";
	
	/**
	 * Search all proposition for questionID
	 * @param questionID
	 * @return
	 * @throws SQLException
	 */
	public static List<Proposition> SearchByQuestion(int questionID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Proposition proposition = null;
		Question question = null;
		List<Proposition> listPropositions = new ArrayList<Proposition>();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SELECT_ALL_FOR_QUESTION);
			rqt.setInt(1, questionID);
			rs=rqt.executeQuery();

			while (rs.next()){
				question = QuestionDAO.SearchByID(rs.getInt("idQuestion"));
				proposition = new Proposition();
				proposition.setId(rs.getInt("id"));
				proposition.setStatement(rs.getString("statement"));
				proposition.setTrue(rs.getBoolean("isTrue"));
				proposition.setQuestion(question);
				
				// Add this proposition to list and go to next.
				listPropositions.add(proposition);
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return listPropositions;
	}
}
