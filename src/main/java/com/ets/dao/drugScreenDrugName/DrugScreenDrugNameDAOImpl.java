package com.ets.dao.drugScreenDrugName;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ets.model.DrugScreenDrugName;
import com.ets.model.DrugScreenResult;

@Repository
public class DrugScreenDrugNameDAOImpl implements DrugScreenDrugNameDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<DrugScreenDrugName> view(String activityCode) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(DrugScreenDrugName.class);
		
		criteria.add(Restrictions.ilike("dsType",activityCode));
		List<DrugScreenDrugName> viewList=null;
		try{
			viewList=criteria.list();
		}catch(Exception e){
			e.printStackTrace();
		}tx.commit();
		
		return viewList;
	}

}
