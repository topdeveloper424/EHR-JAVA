package com.ets.service.laboratory;

import java.util.List;

import com.ets.model.Laboratory;

public interface LaboratoryService {

	public void addOrUpdate(Laboratory laboratory);

	public List<Laboratory> view();
	
	public void delete(Integer id);
	
	public Laboratory viewByCode(String code);

}
