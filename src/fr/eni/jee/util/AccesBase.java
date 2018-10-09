package fr.eni.jee.util;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccesBase {
	private static InitialContext jndi;
	private static DataSource ds;
	static {
		// Charger l'annuaire JNDI
		try {
			jndi = new InitialContext();
			// Chercher le pool de connexions dans l'annuaire
			ds=(DataSource) jndi.lookup("java:comp/env/jdbc/BDD_QCM");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection cnx=null;
		// Activer une connexion du pool
		if (ds != null)
			cnx=ds.getConnection();
		
		return cnx;
	}
}
