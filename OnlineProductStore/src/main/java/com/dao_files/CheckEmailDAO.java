package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean_files.UserBean;

public class CheckEmailDAO {

	private UserBean ub = null;

	public UserBean checkMail(String mid) {

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from usertab where mid=?");

			ps.setString(1, mid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ub = new UserBean();
				ub.setPass(rs.getString(2));
				ub.setMid(rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ub;
	}

}
