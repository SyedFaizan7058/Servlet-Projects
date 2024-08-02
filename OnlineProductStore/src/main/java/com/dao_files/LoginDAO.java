package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean_files.UserBean;

public class LoginDAO {

	private static UserBean ub=null;

	public UserBean login(String uName, String pass) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from USERTAB where user_name=? AND pass_word=?");

			ps.setString(1, uName);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				ub = new UserBean();

				ub.setuName(rs.getString(1));
				ub.setPass(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setMid(rs.getString(6));
				ub.setPhno(rs.getLong(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ub;
	}

}
