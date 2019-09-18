package com.ets.dao.assesmentQuestion;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.ets.model.AssesmentQuestion;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AssesmentQuestionDAOImpl Class
 *Description: AssesmentQuestion Entity DAO class
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
public class AssesmentQuestionDAOImpl implements AssesmentQuestionDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** This method save the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param assesmentQuestion
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void add(AssesmentQuestion assesmentQuestion) {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(assesmentQuestion);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	/** This method gets all the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of AssesmentQuestion objects
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AssesmentQuestion> list() {

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(AssesmentQuestion.class);

		List<AssesmentQuestion> assesmentQuestionList = null;
		try {
			assesmentQuestionList = criteria.list();
			// tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return assesmentQuestionList;

	}

	/** This method update the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param assesmentQuestion
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(AssesmentQuestion assesmentQuestion) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		try {
			session.update(assesmentQuestion);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	/** This method gets all the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of AssesmentQuestion objects
	 */
	@Override
	public AssesmentQuestion getByID(Integer id) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		AssesmentQuestion assesmentQuestion = null;
		try {
			assesmentQuestion = (AssesmentQuestion) session.get(AssesmentQuestion.class, id);
			//trans.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return assesmentQuestion;
	}

	/** This method delete the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void delete(Integer id) {

		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			AssesmentQuestion assesmentQuestion = (AssesmentQuestion) session.get(AssesmentQuestion.class, id);
			session.delete(assesmentQuestion);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
