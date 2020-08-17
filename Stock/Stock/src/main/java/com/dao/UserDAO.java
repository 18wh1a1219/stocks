package com.dao;

import org.hibernate.SessionFactory;

import com.db.HibernateTemplate;
import com.dto.User;

public class UserDAO {
	private SessionFactory factory = null;
	public int register(User user) { 
		return HibernateTemplate.addObject(user);
	}
	
	public User getCustByUserPass(String loginId,String password) {
		return (User)HibernateTemplate.getObjectByUserPass(loginId,password);
	}
}
