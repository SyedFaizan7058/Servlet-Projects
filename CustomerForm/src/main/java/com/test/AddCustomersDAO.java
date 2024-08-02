package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCustomersDAO {

	int k = 0;

	public int insert(CustomerBean b){

		Connection con = DBConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into customer(?,?,?,?,?)");
			k = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}

}
