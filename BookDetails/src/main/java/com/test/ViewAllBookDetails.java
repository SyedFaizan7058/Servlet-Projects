package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewAllBookDetails {

	ArrayList<BookBean> list = new ArrayList<>();

	public ArrayList<BookBean> retreive() {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				BookBean b = new BookBean();
				b.setCode(rs.getString(1));
				b.setName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getFloat(4));
				b.setQty(rs.getInt(5));
				list.add(b);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

}
