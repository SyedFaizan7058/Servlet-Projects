package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePasswordDAO {

	private int k = 0;

	public int updatePassword(UserBean ub) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("update userreg set pass_word=? where mid=?");

			ps.setString(1, ub.getPass());
			ps.setString(2, ub.getMid());

			k = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}

}
