package com.ets.dao.representRelation;

import java.util.List;

import com.ets.model.RepresentRelation;

public interface RepresentRelationDAO {

	public void add(RepresentRelation representRelation);
	public List<RepresentRelation> viewrelationList(Integer patID);
	public void saveOrUpdate(RepresentRelation representRelation);
	//public RepresentRelation getByRelationId(Integer id);
	public void delete(Integer id);
	//public void view(RepresentRelation representRelation);
}
