package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Test;
import fr.eni.jee.bo.Theme;
import fr.eni.jee.util.AccessDB;

public class ThemeDAO {

	private static Connection connection;
	private final static String SEARCH_BY_ID = "SELECT id, label FROM THEME WHERE id =?";
	private final static String INSERT = "INSERT INTO THEME (label) values (?)";
	private final static String GET_ALL = "SELECT id, label FROM THEME";
	private final static String DELETE_BY_ID = "DELETE FROM THEME WHERE id =?";
	private final static String UPDATE_BY_ID = "UPDATE THEME SET label=? WHERE id=?";
	
	public static Theme Insert(Theme theme) throws SQLException{
		if (theme != null) {
			
			connection = AccessDB.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, theme.getLabel());        
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        theme.setId(rs.getInt(1));
                    }
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return theme;
	}
	
	public static Theme SearchByID(int id) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Theme theme = new Theme();
		
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, id);
			rs=rqt.executeQuery();

			if(rs.next()){								
				theme.setId(rs.getInt("id"));
				theme.setLabel(rs.getString("label"));
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return theme;
	}	
	
	public static List<Theme> GetAll() throws SQLException{
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Theme theme = null;
		List<Theme> lstTheme = new ArrayList<Theme>();

		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(GET_ALL);
			rs=rqt.executeQuery();

			while (rs.next()){
				theme = new Theme();
								
				theme.setId(rs.getInt("id"));				
				theme.setLabel(rs.getString("label"));				
				
				lstTheme.add(theme);
			}			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}		
		
		return lstTheme;
	}
	
	
	public static void Delete(Theme theme) throws SQLException{
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try{
			cnx = AccessDB.getConnection();			 
			
			rqt = cnx.prepareStatement(DELETE_BY_ID);			
			rqt.setInt(1, theme.getId());			
			rqt.executeUpdate();		
		}	
		finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	private static void Update(Theme theme) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		
		try{
			cnx = AccessDB.getConnection();			 
			
			rqt = cnx.prepareStatement(UPDATE_BY_ID);			
			rqt.setString(1, theme.getLabel());	
			rqt.setInt(2, theme.getId());	
			rqt.executeUpdate();		
		}	
		finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
	}
}
