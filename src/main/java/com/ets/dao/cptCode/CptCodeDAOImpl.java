package com.ets.dao.cptCode;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.Division;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CptCodeDAOImpl Class
 *Description: CptCode Entity DAO class
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
public class CptCodeDAOImpl implements CptCodeDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param cptCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void add(CptCode4Hcpcs cptCode) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(cptCode);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	/** This method gets all the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CptCode objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CptCode4Hcpcs> list() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(CptCode4Hcpcs.class);

		List<CptCode4Hcpcs> cptCodeList = null;
		try {
			cptCodeList = criteria.list();
			 tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} /*finally {
			session.close();
		}*/

		return cptCodeList;
	}

	/** This method update the cptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param cptCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void update(CptCode4Hcpcs cptCode) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(cptCode);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	/** This method gets all the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CptCode objects
	 */
	
	@Override
	public CptCode4Hcpcs getByID(Integer id) {
	
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		CptCode4Hcpcs cptCode = null;
		try {
			cptCode = (CptCode4Hcpcs) session.get(CptCode4Hcpcs.class, id);
			trans.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} /*finally {
			session.close();
		}*/
		return cptCode;
	}

	
	/** This method Remove the cptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void delete(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			CptCode4Hcpcs cptCode = (CptCode4Hcpcs) session.get(CptCode4Hcpcs.class, id);
			session.delete(cptCode);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param code
	 * @since 31-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CptCode objects
	 */
	
	@Override
	public CptCode4Hcpcs viewByCode(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(CptCode4Hcpcs.class);
		criteria.add(Restrictions.eq("code", code));
		List<CptCode4Hcpcs> cptCode4HcpcsList = null;
		
		try{
			
			cptCode4HcpcsList = criteria.list();
			tx.commit();
						
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		if(cptCode4HcpcsList.isEmpty()){
			
			return null;
			
		}else{
			
			return cptCode4HcpcsList.get(0);
		}
	}

}
