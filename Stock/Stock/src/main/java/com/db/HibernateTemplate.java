

	package com.db;

	import java.io.Serializable;
	import java.util.Date;
	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.criterion.Criterion;
	import org.hibernate.criterion.Restrictions;

import com.dto.BSE;
import com.dto.Companies;
import com.dto.NSE;
import com.dto.User;

	

	public class HibernateTemplate {

		private static SessionFactory sessionFactory;

		static {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}

		public static int addObject(Object obj){
			System.out.println("Inside Template...");
			int result=0;
			Transaction tx=null;	
			try {
				Session session=sessionFactory.openSession();
				tx=session.beginTransaction();
				session.save(obj);
				tx.commit();
				result=1;
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
			return result;
		}

		public static Object getObject(Class c,Serializable serializable)
		{
			Object obj=null;
			try {			
				return sessionFactory.openSession().get(c,serializable);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return obj;
		}

		public static User getObjectByUserPass(String email,String password) {
			String queryString = "from User where email = :email and password =:password";
			Query query = sessionFactory.openSession().createQuery(queryString);
			query.setString("email", email);
			query.setString("password", password);
			Object queryResult = query.uniqueResult();
			User user = (User)queryResult;
			return user; 
		}
		/*
		public static Object getObjectById(int serviceId) {
			//sessionFactory.close();
			String queryString = "from Service where serviceId = :serviceId";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(queryString);
			query.setInteger("serviceId", serviceId);
			Object queryResult = query.uniqueResult();
			Service service = (Service)queryResult;
			session.close();
			return service; 
		}
		public static Object getObjectByIdd(int id) {
			//sessionFactory.close();
			String queryString = "from Services where id = :id";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			Object queryResult = query.uniqueResult();
			Services services = (Services)queryResult;
			session.close();
			return services; 
		}
		
		*/

		public static List<Object> getObjectListByQuery(String query)
		{
			return sessionFactory.openSession().createQuery(query).list();
		}

		public static int updateObject(Object obj)
		{
			int result=0;
			Transaction tx=null;
			try {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				SessionFactory factory = config.buildSessionFactory();
				Session session = factory.openSession();
				tx = session.beginTransaction();

				session.saveOrUpdate(obj);
				tx.commit();
				result = 1;}
			catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
			/*


				Session session=sessionFactory.openSession();
				tx=session.beginTransaction();
				session.saveOrUpdate(obj);
				tx.commit();
				result=1;
			}*/
			return result;
		}

		public static int deleteObject(Class c,Serializable serializable)
		{
			int result=0;
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			try {
				Object obj=session.get(c,serializable);
				session.delete(obj);
				tx.commit();
				result=1;
			} catch (Exception e) {
				e.printStackTrace();
				tx.rollback();
			}
			session.close();
			return result;
		}



		public static List<Object> getObjectListByName(Class c, String columName, String value) {
			Session session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
		}
		
	/*	public static void delete(int Id) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Workers emp = (Workers) session.get(Workers.class, Id);
			if(emp!=null){
				session.delete(emp);}
			tx.commit();
		}
		
		public static void deletee(int Id) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			SessionFactory factory = config.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			Services emp = (Services) session.get(Services.class, Id);
			if(emp!=null){
				session.delete(emp);}
			tx.commit();
		}

		public static List<Object> getObjectListById(Class c, Object obj, int value) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			Criteria criteria = session.createCriteria(c);
			//if(c == Book.class) {
			//	Criterion nameCriterion = Restrictions.eq("customer.id", value);
			//	criteria.add(nameCriterion);
			//	return criteria.list();
			//}
			
			//else {
				Criterion nameCriterion = Restrictions.eq("service.id", value);
				criteria.add(nameCriterion);
				return criteria.list();}

		public static Service getServiceByUserPass(String email, String password) {
			// TODO Auto-generated method stub
			String queryString = "from Service where email = :email and password =:password";
			Session session=sessionFactory.openSession();
			Query query = session.createQuery(queryString);
			query.setString("email", email);
			query.setString("password", password);
			Object queryResult = query.uniqueResult();
			Service service = (Service)queryResult;
			return service;
		}
		public static List<Book> getObjectListByIddd(int serviceId) {
			String queryString = "select * from Book where serviceId = :serviceId";
			//Session session=sessionFactory.openSession();
			//Query query = session.createQuery(queryString);
			//query.setInteger("serviceId", serviceId);
			//query.setString("password", password);
			//Object queryResult = query.uniqueResult();
			//Service service = (Service)queryResult;
			String hql = "from Book where serviceId = :serviceId";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setInteger("serviceId", serviceId);
			List<Book> logEntries = query.list();
			return logEntries;
	}
		public static List<Book> getObjectListBywId(int workerId) {
			String queryString = "select * from Book where workerId = :workerId";
			//Session session=sessionFactory.openSession();
			//Query query = session.createQuery(queryString);
			//query.setInteger("serviceId", serviceId);
			//query.setString("password", password);
			//Object queryResult = query.uniqueResult();
			//Service service = (Service)queryResult;
			String hql = "from Book where workerId = :workerId";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setInteger("workerId", workerId);
			List<Book> logEntries = query.list();
			return logEntries;
	}
*/
		public static NSE getObjectByDate(java.sql.Date date) {
			String queryString = "from NSE where date = :date";
			Query query = sessionFactory.openSession().createQuery(queryString);
			query.setDate("date", date);
			Object queryResult = query.uniqueResult();
			NSE nSE = (NSE)queryResult;
			return nSE;
		}
		
		public static BSE getObjectByDat(java.sql.Date date) {
			String queryString = "from BSE where date = :date";
			Query query = sessionFactory.openSession().createQuery(queryString);
			query.setDate("date", date);
			Object queryResult = query.uniqueResult();
			BSE bSE = (BSE)queryResult;
			return bSE;
		}

	

		public static Companies getStockByDate(String companyName, java.sql.Date date) {
			// TODO Auto-generated method stub
			String queryString = "from Companies where companyName = :companyName and date = :date";
			Query query = sessionFactory.openSession().createQuery(queryString);
			query.setString("companyName", companyName);
			query.setDate("date", date);
			Object queryResult = query.uniqueResult();
			Companies c = (Companies)queryResult;
			return c;
		}

	/*	public static List<Book> getBookingListById(int custId) {
			// TODO Auto-generated method stub
			String queryString = "select * from Book where custId = :custId";

			String hql = "from Book where custId = :custId";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setInteger("custId", custId);
			List<Book> logEntries = query.list();
			return logEntries;
		}

		public static List getObjectListByDate(int serviceId, Date date) {
			// TODO Auto-generated method stub
			String hql = "from Book where serviceId = :serviceId and DATE_FORMAT(date,'%Y-%m-%d') = :date";
			Session session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			query.setInteger("serviceId", serviceId);
			query.setDate("date", date);
			List<Book> logEntries = query.list();
			return logEntries;
		}*/
	}

