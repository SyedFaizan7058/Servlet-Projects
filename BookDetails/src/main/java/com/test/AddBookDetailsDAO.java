package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

public class AddBookDetailsDAO {

	int k = 0;

	public int insert(BookBean b) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?,?)");

			ps.setString(1, b.getCode());
			ps.setString(2, b.getName());
			ps.setString(3, b.getAuthor());
			ps.setFloat(4, b.getPrice());
			ps.setInt(5, b.getQty());

			k = ps.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {

			System.out.println(e.toString());

		} catch (SQLSyntaxErrorException e) {

			System.out.println(e.toString());

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return k;

	}

}
