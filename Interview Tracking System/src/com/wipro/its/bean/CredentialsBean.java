package com.wipro.its.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITS_TBL_User_Credentials")
public class CredentialsBean {

	@Id
	@Column(name = "USERID")
	private String userID;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USERTYPE")
	private String userType;

	@Column(name = "LOGINSTATUS")
	private int loginStatus;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

}
