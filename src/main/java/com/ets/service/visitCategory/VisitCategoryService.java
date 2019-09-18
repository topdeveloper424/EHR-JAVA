package com.ets.service.visitCategory;

import java.util.List;

import com.ets.model.VisitCategory;

public interface VisitCategoryService {
	
	public void addOrUpdate(VisitCategory visitCategory);
	
	public List<VisitCategory> view();
	
	public void delete(Integer id);
	
	public VisitCategory viewByCode(String code);

}
