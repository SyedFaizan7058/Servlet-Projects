package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {

	private int k = 0;

	public int insert(StudentBean sb) {

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into student58 values(?,?,?,?)");
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getId());
			ps.setString(3, sb.getAddr());
			ps.setString(4, sb.getPhno());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
