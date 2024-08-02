package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO {

	private int k = 0;

	public int update(UserBean ub) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update userReg set addr=?,mid=?,phno=? where user_name=? AND pass_word=?");
			ps.setString(1, ub.getAddr());
			ps.setString(2, ub.getMid());
			ps.setLong(3, ub.getPhno());
			ps.setString(4, ub.getuName());
			ps.setString(5, ub.getPass());
			
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}

}
