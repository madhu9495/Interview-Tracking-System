package com.wipro.its.util;

import com.wipro.its.bean.CredentialsBean;

public interface User {
	public String login(CredentialsBean credentialsBean);

	public boolean logout(String userId);

	public String changePassword(CredentialsBean credentialsBean, String newPassword);
}
