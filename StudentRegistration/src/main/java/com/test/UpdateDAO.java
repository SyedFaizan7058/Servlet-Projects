package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO {

	private int k = 0;

	public int update(StudentBean sb) {
		
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("update student58 set address=? where id=?");
			
			ps.setString(1, sb.getAddr());
			ps.setString(2, sb.getId());
			
			k = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}

}
