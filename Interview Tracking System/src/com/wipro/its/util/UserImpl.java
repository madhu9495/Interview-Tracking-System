package com.wipro.its.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.its.bean.CredentialsBean;

@Service
public class UserImpl implements User {
	@Autowired(required = true)
	public Authentication authentication;

	public User user;

	@Autowired
	public SessionFactory sessionFactory;
	CredentialsBean credentialsBean1;
	Session session;
	Query query;

	boolean result;
	String check;

	@Transactional
	@Override
	public String login(CredentialsBean credentialsBean) {

		if (credentialsBean == null) {
			check = "INVALID";
		} else if (credentialsBean.getUserID() == null || credentialsBean.getPassword() == null) {
			check = "INVALID";
		} else if (credentialsBean.getUserID().equals("") || credentialsBean.getPassword().equals("")) {
			check = "INVALID";
		} else {

			result = authentication.authenticate(credentialsBean);
			if (result) {

				return authentication.authorize(credentialsBean.getUserID());
			} else {
				return check = "INVALID";
			}

		}

		return check;

	}

	@Transactional
	@Override
	public boolean logout(String userId) {
		session = sessionFactory.getCurrentSession();
		credentialsBean1 = (CredentialsBean) session.load(CredentialsBean.class, userId);
		credentialsBean1.setLoginStatus(0);
		return true;

	}

	@Transactional
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
		session = sessionFactory.getCurrentSession();
		CredentialsBean s = (CredentialsBean) session.get(CredentialsBean.class, credentialsBean.getUserID());
		if (s == null) {
			return "FAIL";
		} else if (s.getLoginStatus() == 0) {
			return "FAIL";
		} else {
			if (s.getPassword().equals(credentialsBean.getPassword())) {

				s.setPassword(newPassword);
				return "SUCCESS";
			} else {
				return "INVALID";
			}
		}
	}

}
