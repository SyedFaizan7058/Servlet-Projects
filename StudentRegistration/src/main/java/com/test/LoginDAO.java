package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private StudentBean sb=null;

	public StudentBean login(String name, String id) {
		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("select * from student58 where name=? and id=?");

			ps.setString(1, name);
			ps.setString(2, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sb = new StudentBean();
				sb.setName(rs.getString(1));
				sb.setId(rs.getString(2));
				sb.setAddr(rs.getString(3));
				sb.setPhno(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb;
	}

}
