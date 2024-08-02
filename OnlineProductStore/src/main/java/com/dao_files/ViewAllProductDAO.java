package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean_files.ProductBean;

public class ViewAllProductDAO {

	private ArrayList<ProductBean> list = new ArrayList<>();

	public ArrayList<ProductBean> fetch() {

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from product58");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getDouble(3));
				pb.setQty(rs.getInt(4));
				pb.setImageUrl(rs.getString(5));
				list.add(pb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
