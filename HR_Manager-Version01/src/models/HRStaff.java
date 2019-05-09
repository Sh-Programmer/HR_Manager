
/**
 * Model - HR Staff Class 
 */


package models;

import java.io.Serializable;

public class HRStaff implements User, Serializable{

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
