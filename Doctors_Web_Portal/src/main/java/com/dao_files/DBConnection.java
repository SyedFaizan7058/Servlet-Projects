package com.dao_files;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.dao_files.DBInfo.*;

public class DBConnection {

	static Connection con;

	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return con;
	}

}
