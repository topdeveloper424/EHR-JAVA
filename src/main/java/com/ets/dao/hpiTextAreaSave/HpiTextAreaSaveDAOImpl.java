package com.ets.dao.hpiTextAreaSave;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.EmrChartingTextAreaSave;

@Repository
public class HpiTextAreaSaveDAOImpl implements HpiTextAreaSaveDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveOrUpdate(EmrChartingTextAreaSave hpiTextAreaSave) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
		session.saveOrUpdate(hpiTextAreaSave);
		tx.commit();
		  } catch (HibernateException e) {
			   e.printStackTrace();
			  } 
		}

	@Override
	public List<EmrChartingTextAreaSave> viewAll(Integer patVisitId) {
		 Session session=sessionFactory.getCurrentSession();
		  Transaction tx = session.beginTransaction();
		  List<EmrChartingTextAreaSave> emrHpis=null;
		  try {

			  Criteria criteria=session.createCriteria(EmrChartingTextAreaSave.class);
			  criteria.add(Restrictions.eq("patientVisit.id", patVisitId));
				
				emrHpis=criteria.list();
				
			}
				

			catch (Exception e) {
					tx.rollback();
				e.printStackTrace();
			}tx.commit();

		   return emrHpis;
	}
	
	/*public List<EmrHpiTextAreaSave> view() {
		
		  Session session=sessionFactory.getCurrentSession();
		  Transaction tx = session.beginTransaction();
		  List<EmrHpiTextAreaSave> emrHpis=null;
		  try {

			  Criteria criteria=session.createCriteria(EmrHpiTextAreaSave.class);
				
				emrHpis=criteria.list();
				
			}
				

			catch (Exception e) {
					tx.rollback();
				e.printStackTrace();
			}tx.commit();

		   return emrHpis;

}*/
	
	
}
