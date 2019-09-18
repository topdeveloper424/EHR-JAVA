package com.ets.service.assesment;

import java.util.List;

import com.ets.model.Assesment;
import com.ets.model.Icd10Codes;

public interface AssesmentService {
	

	public void saveOrUpdate(Assesment assesment);
	public List<Assesment> search(Integer id);
	public List<Assesment> view();
	
	public void delete(Integer id);
	
	

}
