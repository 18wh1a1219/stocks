package com.dao;

import java.util.List;

import com.db.HibernateTemplate;
import com.dto.Companies;
import com.dto.NSE;

public class NseDAO {

	public NSE getNseByDate(java.sql.Date date) {	
		System.out.println(date);
		return (NSE)HibernateTemplate.getObjectByDate(date);
	}
}
