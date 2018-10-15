package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Profile;
import fr.eni.jee.bo.Promotion;
import fr.eni.jee.bo.User;
import fr.eni.jee.util.AccessDB;

public class UserDAO {
	private static final String SEARCH_BY_ID ="SELECT id, lastname, firstname, email, password, idProfile, idPromotion FROM USERS WHERE id=?";
	private static final String SEARCH ="SELECT id, lastname, firstname, email, password, idProfile, idPromotion FROM USERS WHERE email=? and password=?";
	private static final String INSERT = "INSERT INTO USERS (lastname, firstname, email, password, idProfile, idPromotion) values (?,?,?,?,?,?)";
	private static final String MODIFY ="UPDATE USERS SET lastname = ?, firstname = ?, email = ?, password=?,idProfile=?, idPromotion=? where id = ?";
	private static final String DELETE ="DELETE FROM USERS where id = ?";
	private static final String GET_ALL ="SELECT id, lastname, firstname, email, password, idProfile, idPromotion FROM USERS";
	private static final String SEARCH_BY_PROMOTION = "SELECT id, lastname, firstname, email, password, idProfile, idPromotion FROM USERS WHERE idPromotion=?";

	public static User SearchById(int userID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		User user = null;
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, userID);
			rs=rqt.executeQuery();

			if (rs.next()){
				Profile profile = ProfileDAO.SearchByID(rs.getInt("idProfile"));
				Promotion promo = PromotionDAO.SearchByID(rs.getInt("idPromotion"));
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLastname(rs.getString("lastname"));
				user.setFirstname(rs.getString("firstname"));
				user.setMail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setProfile(profile);
				user.setPromotion(promo);
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return user;
	}

	public static User Search(String mail, String password) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		User user =null;
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH);
			rqt.setString(1, mail);
			rqt.setString(2, password);
			rs=rqt.executeQuery();
			
			if (rs.next()){
				Profile profile = ProfileDAO.SearchByID(rs.getInt("idProfile"));
				Promotion promo = PromotionDAO.SearchByID(rs.getInt("idPromotion"));
				System.out.println(promo);
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLastname(rs.getString("lastname"));
				user.setFirstname(rs.getString("firstname"));
				user.setMail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setProfile(profile);
				user.setPromotion(promo);
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return user;
	}

	public static User Insert(User user) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccessDB.getConnection();
			 
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, user.getLastname());
			rqt.setString(2, user.getFirstname());
			rqt.setString(3, user.getMail());
			rqt.setString(4, user.getPassword());
			rqt.setInt(5, user.getProfile().getId());
			if(user.getPromotion().getId() > 0){
				rqt.setInt(6, user.getPromotion().getId());
			}
			else{
				rqt.setString(6, null);
			}
			
			rqt.executeUpdate();
			ResultSet key = rqt.getGeneratedKeys();
			key.next();
			user.setId(key.getInt(1));
			
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
		
		return user;

	}

	public static void Update(User user) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccessDB.getConnection();
			rqt=cnx.prepareStatement(MODIFY);
			rqt.setString(1, user.getLastname());
			rqt.setString(2, user.getFirstname());
			rqt.setString(3, user.getMail());
			rqt.setString(4, user.getPassword());
			rqt.setInt(5, user.getProfile().getId());
			rqt.setInt(6, user.getPromotion().getId());
			rqt.setInt(7, user.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void Delete(User user) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccessDB.getConnection();
			rqt=cnx.prepareStatement(DELETE);
			rqt.setInt(1, user.getId());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static List<User> search() throws SQLException {
		
		List<User> usersList = new ArrayList<User>();
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(GET_ALL);
			rs=rqt.executeQuery();
			
			while (rs.next()){
				Profile profile = ProfileDAO.SearchByID(rs.getInt("idProfile"));
				Promotion promo = PromotionDAO.SearchByID(rs.getInt("idPromotion"));
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLastname(rs.getString("lastname"));
				user.setFirstname(rs.getString("firstname"));
				user.setMail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setProfile(profile);
				user.setPromotion(promo);
				
				usersList.add(user);
			}

			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return usersList;
		
	}
	
	/**
	 * Return all users with promo id.
	 * @param promoID
	 * @return
	 * @throws SQLException
	 */
	public static List<User> SearchByPromo(int promoID) throws SQLException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<User>();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_PROMOTION);
			rqt.setInt(1, promoID);
			rs = rqt.executeQuery();

			while (rs.next()){
				Profile profile = ProfileDAO.SearchByID(rs.getInt("idProfile"));
				Promotion promo = PromotionDAO.SearchByID(rs.getInt("idPromotion"));
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLastname(rs.getString("lastname"));
				user.setFirstname(rs.getString("firstname"));
				user.setMail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setProfile(profile);
				user.setPromotion(promo);
				
				users.add(user);
			}

			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return users;
		
	}
	
}
