package com.ets.service.departmentUnit;

import java.util.List;

import com.ets.model.DepartmentUnit;

public interface DepartmentUnitService {
	
	public void add(DepartmentUnit departmentUnit);
	
	public List<DepartmentUnit> view();
	
	public DepartmentUnit getById(Integer id);
	
	public void update(DepartmentUnit departmentUnit);
	
	public void delete(Integer id);
	
	public DepartmentUnit viewByCode(String code);

}
