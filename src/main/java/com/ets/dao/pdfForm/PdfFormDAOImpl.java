package com.ets.dao.pdfForm;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.ets.model.PdfForm;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PdfFormDAOImpl Class
 *Description: PdfForm Entity DAO class
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
public class PdfFormDAOImpl implements PdfFormDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pdfForm
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void add(PdfForm pdfForm) {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(pdfForm);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

	/** This method gets all the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of PdfForm objects
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PdfForm> list() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(PdfForm.class);

		List<PdfForm> pdfFormList = null;
		try {
			pdfFormList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return pdfFormList;
		
	}

	/** This method update the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pdfForm
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void update(PdfForm pdfForm) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(pdfForm);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	/** This method gets all the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of PdfForm objects
	 */
	
	@Override
	public PdfForm getByID(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		PdfForm pdfForm = null;
		try {
			pdfForm = (PdfForm) session.get(PdfForm.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pdfForm;
	}

	/** This method delete the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void delete(Integer id) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			PdfForm pdfForm = (PdfForm) session.get(PdfForm.class, id);
			session.delete(pdfForm);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}

}
