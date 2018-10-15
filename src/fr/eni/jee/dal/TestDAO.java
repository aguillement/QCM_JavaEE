package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.Test;
import fr.eni.jee.bo.Theme;
import fr.eni.jee.util.AccessDB;

public class TestDAO {
	
	private static final String GET_ALL = "SELECT id, label, statement, duration, high_level, low_level FROM TEST";
 	private static final String SEARCH_BY_ID = "SELECT id, label, statement, duration, high_level, low_level FROM TEST WHERE id=?";
	private static final String INSERT = "INSERT INTO TEST (label, statement, duration, high_level, low_level) VALUES (?, ?, ?, ?, ?)";
	
	public static List<Test> GetAll() throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Test> tests = new ArrayList<Test>();
		
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(GET_ALL);
			rs=rqt.executeQuery();

			while(rs.next()){
				Test test = new Test();
				test.setId(rs.getInt("id"));
				test.setLabel(rs.getString("label"));
				test.setDuration(rs.getInt("duration"));
				test.setStatement(rs.getString("statement"));
				test.setHigh_level(rs.getInt("high_level"));
				test.setLow_level(rs.getInt("low_level"));
				
				tests.add(test);
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return tests;
	}
	
	
	public static Test SearchByID(int testID) throws SQLException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Test test = new Test();
		
		try{
			cnx = AccessDB.getConnection();
			rqt = cnx.prepareStatement(SEARCH_BY_ID);
			rqt.setInt(1, testID);
			rs=rqt.executeQuery();

			if(rs.next()){				
				test.setId(rs.getInt("id"));
				test.setLabel(rs.getString("label"));
				test.setDuration(rs.getInt("duration"));
				test.setStatement(rs.getString("statement"));
				test.setHigh_level(rs.getInt("high_level"));
				test.setLow_level(rs.getInt("low_level"));
			}
			
		}finally{
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return test;
	}
	
	public static Test Insert(Test test) throws SQLException{
				
		if (test != null) {
			Connection connection = AccessDB.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, test.getLabel());   
                ps.setString(2, test.getStatement());   
                ps.setInt(3, test.getDuration());   
                ps.setInt(4, test.getHigh_level());   
                ps.setInt(5, test.getLow_level());   
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                    	test.setId(rs.getInt(1));
                    }
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return test;
	}
}
