package jp.co.comnic.javalesson.inventory.contorl.model;

import java.io.Serializable;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String email;

	private String password;


	public Account() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
		
	}

}