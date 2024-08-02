package com.test;

import static com.test.DBInfo.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con = null;

	private DBConnection() {
	}

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}

}
