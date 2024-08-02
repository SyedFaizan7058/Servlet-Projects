package com.test;

import static com.test.DBInfo.PASSWORD;
import static com.test.DBInfo.URL;
import static com.test.DBInfo.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con = null;

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
