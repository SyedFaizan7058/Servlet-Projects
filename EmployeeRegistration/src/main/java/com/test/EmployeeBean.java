package com.test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeBean implements Serializable {

	private Integer empId;
	private String empName, empAddr, empMailId;
	private Float empSalary;
	private Long empPhno;

	public Long getEmpPhno() {
		return empPhno;
	}

	public void setEmpPhno(Long empPhno) {
		this.empPhno = empPhno;
	}

	public EmployeeBean() {
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public String getEmpMailId() {
		return empMailId;
	}

	public void setEmpMailId(String empMailId) {
		this.empMailId = empMailId;
	}

	public Float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Float empSalary) {
		this.empSalary = empSalary;
	}

}
