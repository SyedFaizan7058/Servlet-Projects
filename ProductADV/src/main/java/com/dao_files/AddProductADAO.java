package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.ProductBean;

public class AddProductADAO {

	private int k = 0;

	public int insert(ProductBean pb) {

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into product58 values(?,?,?,?)");

			ps.setString(1, pb.getCode());
			ps.setString(2, pb.getName());
			ps.setDouble(3, pb.getPrice());
			ps.setInt(4, pb.getQty());

			k = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}

}
