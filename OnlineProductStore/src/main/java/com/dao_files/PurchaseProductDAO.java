package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean_files.ProductBean;

public class PurchaseProductDAO {
	
	private int k = 0;
	
	public int purchase(ProductBean pb) {
		
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("update product58 set qty=? where code=?");
			
			ps.setInt(1, pb.getQty());
			ps.setString(2, pb.getCode());
			
			k = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}

}
