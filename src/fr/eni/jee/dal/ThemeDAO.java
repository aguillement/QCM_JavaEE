package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.jee.bo.Epreuve;
import fr.eni.jee.bo.Theme;
import fr.eni.jee.util.AccesBase;

public class ThemeDAO {
	
	private static final String SEARCH_BY_ID = "SELECT idEpreuve, dateDebutValidite, dateFinValidite, tempsEcoule, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur FROM EPREUVE WHERE idEpreuve=?";

	/**
	 * Search Theme by his ID
	 * @param themeID
	 * @return
	 * @throws SQLException
	 */
	public static Theme SearchByID(int themeID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Epreuve epreuve = null;
		
		Theme theme = new Theme();
		
		try{
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, themeID);
			rs=rqt.executeQuery();

			if(rs.next()){
				theme.setIdTheme(rs.getInt("idTheme"));
				theme.setLibelle(rs.getString("libelle"));
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return theme;
	}
}
