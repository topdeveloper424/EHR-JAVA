package com.ets.dao.departmentUnit;

import java.util.List;

import com.ets.model.DepartmentUnit;

/**
 * Original Author: Sumanta Deyahi on Behalf of ETS for Client Company File
 * Creation Date: 25-07-2016 
 * Initial Version: 0.01 
 * Module Name: 
 * Parameter
 * Definition: Type object of DepartmentUnitDAO Interface
 *  Description: DepartmentUnit Entity DAO Interface
    Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: 
 * Owner: 
 * Date: 
 * Version: 
 * Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

public interface DepartmentUnitDAO {
	
	public void add(DepartmentUnit departmentUnit);
	
	public List<DepartmentUnit> view();
	
	public DepartmentUnit getById(Integer id);
	
	public void update(DepartmentUnit departmentUnit);
	
	public void delete(Integer id);
	
	public DepartmentUnit viewByCode(String code);

}
