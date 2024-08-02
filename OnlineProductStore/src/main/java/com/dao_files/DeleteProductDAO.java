package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProductDAO {

	private int k = 0;

	public int delete(String pcode) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("delete from product58 where code=?");
			ps.setString(1, pcode);
			k = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}

}
