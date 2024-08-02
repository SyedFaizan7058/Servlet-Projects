package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterEmployeeDAO {

	private int k = 0;

	public int registerEmployee(EmployeeBean b) {

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee_info values(?,?,?,?,?,?)");

			ps.setInt(1, b.getEmpId());
			ps.setString(2, b.getEmpName());
			ps.setFloat(3, b.getEmpSalary());
			ps.setString(4, b.getEmpAddr());
			ps.setString(5, b.getEmpMailId());
			ps.setLong(6, b.getEmpPhno());

			k = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return k;
	}

}
