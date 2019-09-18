package com.ets.service.workLocation;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.workLocation.WorkLocationDAO;
import com.ets.model.WorkLocation;

@Transactional
@Service
public class WorkLocationServiceImpl implements WorkLocationService {
	
	private WorkLocationDAO workLocationDAO;

	public void setWorkLocationDAO(WorkLocationDAO workLocationDAO) {
		this.workLocationDAO = workLocationDAO;
	}

	@Override
	public void add(WorkLocation workLocation) {
		
		workLocationDAO.add(workLocation);
	}

	@Override
	public List<WorkLocation> view() {
		
		return workLocationDAO.view();
	}

	@Override
	public void delete(Integer id) {
		
		workLocationDAO.delete(id);
		
	}
	

}
