package com.ets.service.representRelation;

import java.util.List;

import com.ets.model.Region;
import com.ets.model.RepresentRelation;

public interface RepresentRelationService {
	
	public void add(RepresentRelation relation);
	public List<RepresentRelation> viewrelationList(Integer patId);
	public void saveOrUpdate(RepresentRelation relation);

	public void delete(Integer id);
	//public RepresentRelation getByRelationId(Integer id);
	//public void view(RepresentRelation relation);

	

}
