package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.User;
import fr.eni.jee.util.AccessDB;

public class UserDAO {
	private static final String SEARCH_BY_ID ="SELECT id, lastname, firstname, email, password FROM USER WHERE id=?";
	private static final String SEARCH ="SELECT id, lastname, firstname, email, password FROM USER WHERE email=? and password=?";
	private static final String INSERT = "INSERT INTO USER (lastname, firstname, email, password) values (?,?,?,?)";
	private static final String MODIFY ="UPDATE USER SET lastname = ?, firstname = ?, email = ?, password=? where id = ?";
	private static final String DELETE ="DELETE FROM USER where id = ?";
	private static final String GET_ALL ="SELECT id, lastname, firstname, email, password FROM USER";
	
	public static User SearchByID(int userID) throws SQLException{
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
				user = new User();
				user.setIdUser(rs.getInt("id"));
				user.setNom(rs.getString("lastname"));
				user.setPrenom(rs.getString("firstname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
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
				user = new User();
				user.setIdUser(rs.getInt("id"));
				user.setNom(rs.getString("lastnam"));
				user.setPrenom(rs.getString("firstname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return user;
	}

	/*
	 * Ajoute un candidUtilisateurat en base puis retourne le candidUtilisateurat (valoris� avec son idUtilisateur g�n�r� par la base de donn�es)
	 */
	public static User Add(User user) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx = AccessDB.getConnection();
			 
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, user.getLastname());
			rqt.setString(2, user.getFirstname());
			rqt.setString(3, user.getEmail());
			rqt.setString(4, user.getPassword());
			rqt.executeUpdate();
			ResultSet key = rqt.getGeneratedKeys();
			key.next();
			user.setIdUser(key.getInt(1));
			
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
			rqt.setString(3, user.getEmail());
			rqt.setString(4, user.getPassword());
			rqt.setInt(5, user.getId());
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
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLastName(rs.getString("lastname"));
				user.setFirstname(rs.getString("firstname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				usersList.add(user);
			}

			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return usersList;
		
	}
	
	
	
	
	
	
	
}
