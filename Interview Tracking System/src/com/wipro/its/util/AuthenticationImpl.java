package com.wipro.its.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.its.bean.CredentialsBean;

@Repository
@Transactional
public class AuthenticationImpl implements Authentication {

	@Autowired
	public SessionFactory sessionFactory;
	CredentialsBean credentialsBean1;
	Session session;
	Query query;

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		session = sessionFactory.getCurrentSession();
		query = session.createQuery("from CredentialsBean where userID=? and password=?");
		query.setString(0, credentialsBean.getUserID());
		query.setString(1, credentialsBean.getPassword());
		credentialsBean1 = (CredentialsBean) query.uniqueResult();

		if (credentialsBean1 == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String authorize(String userID) {
		String userType = null;
		session = sessionFactory.getCurrentSession();
		query = session.createQuery("from CredentialsBean where userID=?");
		query.setString(0, userID);
		credentialsBean1 = (CredentialsBean) query.uniqueResult();
		if (credentialsBean1 != null) {
			userType = credentialsBean1.getUserType();

			return userType;

		} else {
			return userType;
		}

	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		session = sessionFactory.getCurrentSession();
		credentialsBean = (CredentialsBean) session.load(CredentialsBean.class, credentialsBean.getUserID());
		credentialsBean.setLoginStatus(loginStatus);
		return true;
	}

}
