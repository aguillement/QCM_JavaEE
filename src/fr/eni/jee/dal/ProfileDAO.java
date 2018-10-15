package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.jee.bo.Profile;
import fr.eni.jee.bo.Promotion;
import fr.eni.jee.util.AccessDB;

public class ProfileDAO {
	
	public static final String SEARCH_BY_ID = "SELECT id, label FROM PROFILE WHERE id=?";
	
	public static Profile SearchByID(int profileID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Profile profile =  new Profile();
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, profileID);
			rs=rqt.executeQuery();

			if (rs.next()){
				profile.setId(rs.getInt("id"));
				profile.setLabel(rs.getString("label"));
			}

		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return profile;
	}

}
