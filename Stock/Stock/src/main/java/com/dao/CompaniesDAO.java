package com.dao;

import java.sql.Date;
import java.util.List;

import com.db.HibernateTemplate;
import com.dto.Companies;
import com.dto.NSE;

public class CompaniesDAO {
	
	
	public List<Companies> getStocksByCompany(String category) {	
		return (List)HibernateTemplate.getObjectListByName(Companies.class,"companyName",category);
	}

	public Companies getCompanyStock(String companyName, Date date) {
		// TODO Auto-generated method stub
		return (Companies)HibernateTemplate.getStockByDate(companyName,date);
	}
}
