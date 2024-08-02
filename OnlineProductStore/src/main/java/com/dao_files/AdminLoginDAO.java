package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean_files.AdminBean;

public class AdminLoginDAO {

	private AdminBean ab;

	public AdminBean login(String name, String pass) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("select * from AdminTab where user_name=? and pass_word=?");

			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ab = new AdminBean();
				ab.setUname(rs.getString(1));
				ab.setPword(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setMid(rs.getString(6));
				ab.setPhno(rs.getLong(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ab;

	}

}
