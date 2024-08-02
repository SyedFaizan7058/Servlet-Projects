package com.dao_files;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean_files.Doctor;

public class AddDoctorDAO {

	private int k;

	public int addDoctor(Doctor dr) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO DOCTOR VALUES(?,?,?,?,?)");

			ps.setString(1, dr.getName());
			ps.setString(2, dr.getCity());
			ps.setString(3, dr.getMail());
			ps.setLong(4, dr.getPhno());
			ps.setString(5, dr.getSpeciality());

			k = ps.executeUpdate();

			if (k > 0) {
				System.out.println("Dr. Record inserted Successfullly...");
			}else System.out.println("Not Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}

}
