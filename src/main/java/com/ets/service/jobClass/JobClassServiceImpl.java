package com.ets.service.jobClass;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.jobClass.JobClassDAO;
import com.ets.model.JobClass;

@Service
@Transactional
public class JobClassServiceImpl implements JobClassService {
	
	private JobClassDAO jobClassDAO;

	public void setJobClassDAO(JobClassDAO jobClassDAO) {
		this.jobClassDAO = jobClassDAO;
	}

	@Override
	public void addorUpdate(JobClass jobClass) {
		
		jobClassDAO.addorUpdate(jobClass);
		
	}

	@Override
	public List<JobClass> view() {
		
		return jobClassDAO.view();
	}

	@Override
	public void delete(Integer id) {
		jobClassDAO.delete(id);
		
	}

	@Override
	public JobClass viewByCode(String code) {
		
		return jobClassDAO.viewByCode(code);
	}
	

}
