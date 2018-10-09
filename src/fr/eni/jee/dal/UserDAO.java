package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.User;
import fr.eni.jee.util.AccesBase;

public class UserDAO {

	private static final String SEARCH_BY_ID ="SELECT idUtilisateur, nom, prenom, email, password FROM UTILISATEUR WHERE idUtilisateur=?";
	private static final String SEARCH ="SELECT idUtilisateur, nom, prenom, email, password FROM UTILISATEUR WHERE email=? and password=?";
	private static final String INSERT = "INSERT INTO UTILISATEUR (nom, prenom, email, password) values (?,?,?,?)";
	private static final String MODIFY ="UPDATE UTILISATEUR SET nom = ?, prenom = ?, email = ?, password=? where idUtilisateur = ?";
	private static final String DELETE ="DELETE FROM UTILISATEUR where idUtilisateur = ?";
	private static final String GET_ALL ="SELECT idUtilisateur, nom, prenom, email, password FROM UTILISATEUR";
	
	public static User SearchByidUtilisateur(int idUtilisateur) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		User user = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, idUtilisateur);
			rs=rqt.executeQuery();

			if (rs.next()){
				user = new User();
				user.setIdUser(rs.getInt("idUtilisateur"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
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
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SEARCH);
			rqt.setString(1, mail);
			rqt.setString(2, password);
			rs=rqt.executeQuery();
			
			if (rs.next()){
				user = new User();
				user.setIdUser(rs.getInt("idUtilisateur"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
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
			cnx = AccesBase.getConnection();
			 
			cnx.setAutoCommit(false);
			
			rqt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, user.getNom());
			rqt.setString(2, user.getPrenom());
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

	public static void modifier(User user) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement(MODIFY);
			rqt.setString(1, user.getNom());
			rqt.setString(2, user.getPrenom());
			rqt.setString(3, user.getEmail());
			rqt.setString(4, user.getPassword());
			rqt.setInt(5, user.getIdUser());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static void supprimer(User user) throws SQLException{
		Connection cnx=null;
		PreparedStatement rqt=null;
		try{
			cnx=AccesBase.getConnection();
			rqt=cnx.prepareStatement(DELETE);
			rqt.setInt(1, user.getIdUser());
			rqt.executeUpdate();
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	public static List<User> rechercher() throws SQLException {
		
		List<User> listeUser = new ArrayList<User>();
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(GET_ALL);
			rs=rqt.executeQuery();
			
			while (rs.next()){
				User user = new User();
				user.setIdUser(rs.getInt("idUtilisateur"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				listeUser.add(user);
			}

			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return listeUser;
		
	}
	
	
	
	
	
	
	
}
