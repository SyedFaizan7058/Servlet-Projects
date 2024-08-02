package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean_files.ProductBean;

public class UpdateProductDAO {

	private int k = 0;

	public int update(ProductBean pb) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("update product58 set price=?,qty=? where code=?");

			ps.setDouble(1, pb.getPrice());
			ps.setInt(2, pb.getQty());
			ps.setString(3, pb.getCode());

			k = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}

}
