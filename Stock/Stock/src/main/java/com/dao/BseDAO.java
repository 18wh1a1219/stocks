package com.dao;

import com.db.HibernateTemplate;
import com.dto.BSE;
import com.dto.NSE;

public class BseDAO {
	public BSE getBseByDate(java.sql.Date date) {
		return (BSE)HibernateTemplate.getObjectByDat(date);
	}
}
