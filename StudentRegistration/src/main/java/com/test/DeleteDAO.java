package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {
	
	private int k=0;
	
	public int delete(StudentBean sb) {
		
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("delete from student58 where id=?");
			
			ps.setString(1, sb.getId());
			
			k = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}

}
