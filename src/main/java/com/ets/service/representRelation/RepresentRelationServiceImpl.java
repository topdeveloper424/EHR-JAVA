package com.ets.service.representRelation;

import java.util.List;

import com.ets.dao.representRelation.RepresentRelationDAO;
import com.ets.model.RepresentRelation;

public class RepresentRelationServiceImpl implements RepresentRelationService {
	
	private RepresentRelationDAO relationDAO;

	public void setRelationDAO(RepresentRelationDAO relationDAO) {
		this.relationDAO = relationDAO;
	}

	@Override
	public void add(RepresentRelation relation) {
		
				relationDAO.add(relation);
	}
	
	@Override
	public List<RepresentRelation> viewrelationList(Integer patId) {
		// TODO Auto-generated method stub
		return relationDAO.viewrelationList(patId) ;
	}

	@Override
	public void saveOrUpdate(RepresentRelation relation) {
		// TODO Auto-generated method stub
		relationDAO.saveOrUpdate(relation);
		
	}

	
	/*@Override
	public void view(RepresentRelation relation) {
		// TODO Auto-generated method stub
		relationDAO.view(relation);
		
	}*/

	

	@Override
	public void delete(Integer id) {
		relationDAO.delete(id);		
	}

	/*@Override
	public RepresentRelation getByRelationId(Integer id) {
		// TODO Auto-generated method stub
		return relationDAO.getByRelationId(id);
	}*/
}
	