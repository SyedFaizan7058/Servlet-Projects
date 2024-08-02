package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.bean_files.ProductBean;

public class AddProductADAO {

	private int k = 0;

	public int insert(ProductBean pb) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into product58 values(?,?,?,?,?)");

			ps.setString(1, pb.getCode());
			ps.setString(2, pb.getName());
			ps.setDouble(3, pb.getPrice());
			ps.setInt(4, pb.getQty());
			ps.setString(5, pb.getImageUrl());

			k = ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return k;
	}

}
