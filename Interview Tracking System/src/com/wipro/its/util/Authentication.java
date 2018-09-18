package com.wipro.its.util;

import com.wipro.its.bean.CredentialsBean;

public interface Authentication {

	public boolean authenticate(CredentialsBean credentialsBean);

	public String authorize(String userID);

	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);

}
