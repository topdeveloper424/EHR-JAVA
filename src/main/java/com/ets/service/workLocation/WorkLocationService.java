package com.ets.service.workLocation;

import java.util.List;

import com.ets.model.WorkLocation;

public interface WorkLocationService {
	
	public void add(WorkLocation workLocation);
	
	public List<WorkLocation> view();
	
	public void delete(Integer id);

}
