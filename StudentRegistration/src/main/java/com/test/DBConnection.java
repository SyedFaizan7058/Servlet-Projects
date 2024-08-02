package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.test.DBInfo.*;

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
