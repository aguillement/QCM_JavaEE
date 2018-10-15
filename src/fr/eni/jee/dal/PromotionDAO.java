package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Profile;
import fr.eni.jee.bo.Promotion;
import fr.eni.jee.bo.User;
import fr.eni.jee.util.AccessDB;

public class PromotionDAO {
	
	private static final String GET_ALL = "SELECT id, label FROM PROMOTION";
	private static final String SEARCH_BY_ID = "SELECT id, label FROM PROMOTION WHERE id=?";
	private static final String SEARCH_BY_LABEL = "SELECT id, label FROM PROMOTION WHERE label=?";

	public static List<Promotion> GetAll() throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Promotion> promos = new ArrayList<Promotion>();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(GET_ALL);
			rs=rqt.executeQuery();

			while(rs.next()){
				Promotion promo = new Promotion();
				promo.setId(rs.getInt("id"));
				promo.setLabel(rs.getString("label"));
				
				promos.add(promo);
			}

		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return promos;
	}

	public static Promotion SearchByID(int promotionID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Promotion promo = new Promotion();
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, promotionID);
			rs=rqt.executeQuery();

			if (rs.next()){
				promo.setId(promotionID);
				promo.setLabel(rs.getString("label"));
			}

		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return promo;
	}
	
	public static Promotion SearchByLabel(String label) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Promotion promo = new Promotion();
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_LABEL);
			rqt.setString(1, label);
			rs = rqt.executeQuery();

			if (rs.next()){
				promo.setId(rs.getInt("id"));
				promo.setLabel(label);
			}

		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return promo;
	}
	
}
