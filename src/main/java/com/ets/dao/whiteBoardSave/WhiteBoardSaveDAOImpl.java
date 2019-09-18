package com.ets.dao.whiteBoardSave;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ets.model.WhiteboardSave;



@Repository
public class WhiteBoardSaveDAOImpl  implements WhiteBoardSaveDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(WhiteboardSave whiteboardSave) {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try{
			session.saveOrUpdate(whiteboardSave);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		
	}

	@Override
	public List<WhiteboardSave> viewWhiteBoard() {
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		List<WhiteboardSave> whiteBoardlist=null;
		try{
			Criteria criteria=session.createCriteria(WhiteboardSave.class);
			whiteBoardlist=criteria.list();
			/*String hql = "Select W FROM WhiteboardSave W WHERE W.whiteBoardlist ==null";
			Query query = currentSession().createQuery(hql);*/
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		return whiteBoardlist;
	}

}
