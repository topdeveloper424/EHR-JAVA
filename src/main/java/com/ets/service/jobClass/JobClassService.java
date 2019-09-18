package com.ets.service.jobClass;

import java.util.List;

import com.ets.model.JobClass;

public interface JobClassService {
	
	public void addorUpdate(JobClass jobClass);
	
	public List<JobClass> view();
	public void delete(Integer id);
	public JobClass viewByCode(String code);
}
