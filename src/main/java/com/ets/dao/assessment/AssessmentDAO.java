package com.ets.dao.assessment;

import java.util.List;

import com.ets.model.Assesment;

public interface AssessmentDAO {

	public void saveOrUpdate(Assesment assesment);
	public List<Assesment> search(Integer id);
	public List<Assesment> view();
	
	public void delete(Integer id);
	
}
