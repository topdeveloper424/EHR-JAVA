package com.ets.dao.company;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ets.model.Clinic;
import com.ets.model.Company;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 19-01-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CompanyDAOImpl Class
 *Description: Company Entity DAO class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	private static final Logger logger = LoggerFactory.getLogger(CompanyDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	/** This method save the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param c
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addCompany(Company c) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		try {
			if(c.getId()!=null&&c.getId()!=0){
			Company company=(Company) session.get(Company.class, c.getId());
			session.saveOrUpdate(company);
			}else{
				session.saveOrUpdate(c);
			}
		
		trans.commit();
		//logger.info("Company saved successfully, Company Details=" + c);
		} catch (HibernateException e) {
			   e.printStackTrace();
			  } /*finally {
			   session.close(); 
			  }*/
			 }

	/** This method update the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param c
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void updateCompany(Company c) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
		session.update(c);
		trans.commit();
		logger.info("Company updated successfully, Company Details=" + c);
		//session.close();	
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  }/*finally {
			   session.close(); 
			  }*/
		}

	/** This method gets all the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param Nothing
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of company objects
	 */
	
	@Override
	public List<Company> listCompany() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		List<Company> companyList = null;
		try {
			 companyList = session.createQuery("from Company").list();
		//List<Company> companyList = session.createQuery("Select name, id ,city , state ,telephone , fax, aliasName from Company").list();
		//logger.info("Company List Retrieved successfully : ");
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
		/*for (Company c : companyList) {
			logger.info("Company List Retrieved successfully : " + c);
		}*/
		//session.close();
		return companyList;
	}

	/** This method gets all the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param id
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of company objects
	 */
	@Override
	public Company getCompanyById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<Company> companyList = null;
		try {
		 companyList = session.createQuery("from Company").list();
		// tx.commit();
		for (Company c : companyList) {
			//logger.info("Company List : " + c);
		}
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } finally {
			   session.close(); 
			  }
		//session.close();
		return companyList.get(0);
	}

	/** This method delete the company objects currently present in the system .
	 * 
	 * @author Indronil Chaudhuri
	 * @param id
	 * @since 19-01-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void removeCompany(int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
		//Company c = (Company) session.load(Company.class, new Integer(id));
		String hql="DELETE FROM Company WHERE id=:id";
		if (id!=0) {
			//session.delete(c);
			Query query=session.createQuery(hql);
			query.setInteger("id", id);
			 query.executeUpdate();
			System.out.println("**************Deleted******* from comp");
			tx.commit();
		}}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		//logger.info("Company deleted successfully, Company details=" + c);
		
	}

	@Override
	public Company getByName(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Company.class);
		criteria.add(Restrictions.eq("name", name));
		List<Company> companyList = null;
		try {

			companyList = criteria.list();
			//tx.commit();

		} catch (Exception e) {

			e.printStackTrace();

		}tx.commit();
		if(companyList.isEmpty()){
			
			return null;
			
		}else{
			
			return companyList.get(0);
			
		}
		
		
	
	}
}