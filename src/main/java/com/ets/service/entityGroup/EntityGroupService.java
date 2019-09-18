package com.ets.service.entityGroup;

import java.util.List;

import com.ets.model.EntityGroup;

public interface EntityGroupService {
	
	public void addOrUpdate(EntityGroup entityGroup);
	
	public List<EntityGroup> view();
	
	public EntityGroup getById(Integer id);
	
	public void delete(Integer id);

}
