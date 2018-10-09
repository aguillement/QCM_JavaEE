package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.Test;
import fr.eni.jee.util.AccessDB;

public class TestDAO {
	
	private static final String SEARCH_BY_ID = "SELECT idTest, libelle, description, duree, seuil_haut, seuil_bas FROM TEST WHERE idTest=?";
	
	/**
	 * Search Test by ID
	 * @param userID
	 * @return
	 * @throws SQLException
	 */
	public static Test SearchById(int testID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Test test = null;

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, testID);
			rs=rqt.executeQuery();

			while (rs.next()){
				test = new Test();
				test.setIdTest(rs.getInt("idTest"));
				test.setLibelle(rs.getString("libelle"));
				test.setDescription(rs.getString("description"));
				test.setDuree(rs.getInt("duree"));
				test.setSeuil_bas(rs.getInt("seuil_bas"));
				test.setSeuil_haut(rs.getInt("seuil_haut"));
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return test;
	}
}
