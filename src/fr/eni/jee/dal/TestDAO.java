package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.bo.ExamQuestion;
import fr.eni.jee.bo.Test;
import fr.eni.jee.util.AccessDB;

public class TestDAO {
	
	private static final String SEARCH_BY_ID = "SELECT id, label, statement, duration, high_level, low_level FROM TEST WHERE id=?";

	
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
}
