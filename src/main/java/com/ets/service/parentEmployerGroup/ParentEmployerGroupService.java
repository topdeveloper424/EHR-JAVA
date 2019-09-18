package com.ets.service.parentEmployerGroup;

import java.util.List;

import com.ets.model.ParentEmployerGroup;

public interface ParentEmployerGroupService {
	
	public void add(ParentEmployerGroup parentEmployerGroup);
	
	public List<ParentEmployerGroup> view();
	
	public void delete(Integer id);

}
