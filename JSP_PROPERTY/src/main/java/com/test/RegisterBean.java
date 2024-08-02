package com.test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RegisterBean implements Serializable {

	private String name, pass;

	public RegisterBean() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
