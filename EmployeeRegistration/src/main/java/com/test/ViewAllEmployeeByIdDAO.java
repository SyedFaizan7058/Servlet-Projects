package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewAllEmployeeByIdDAO {

	ArrayList<EmployeeBean> list = new ArrayList<>();

	public ArrayList<EmployeeBean> getEmployeeByCode(int id) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee_info where empid=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				EmployeeBean b = new EmployeeBean();
				b.setEmpId(rs.getInt(1));
				b.setEmpName(rs.getString(2));
				b.setEmpSalary(rs.getFloat(3));
				b.setEmpAddr(rs.getString(4));
				b.setEmpMailId(rs.getString(5));
				b.setEmpPhno(rs.getLong(6));

				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

}
