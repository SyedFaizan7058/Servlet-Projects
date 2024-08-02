package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean_files.UserBean;

public class RegisterDAO {

	private Integer k = 0;

	public Integer register(UserBean ub) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("insert into USERtab values(?,?,?,?,?,?,?)");

			ps.setString(1, ub.getuName());
			ps.setString(2, ub.getPass());
			ps.setString(3, ub.getfName());
			ps.setString(4, ub.getlName());
			ps.setString(5, ub.getAddr());
			ps.setString(6, ub.getMid());
			ps.setLong(7, ub.getPhno());

			k = ps.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return k;
	}

}
