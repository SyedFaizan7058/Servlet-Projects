package com.test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentBean implements Serializable {

	private String name, hDegree, university;
	private int age, year;
	private long phno;

	public StudentBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String gethDegree() {
		return hDegree;
	}

	public void sethDegree(String hDegree) {
		this.hDegree = hDegree;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

}
