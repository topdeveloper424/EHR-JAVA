package com.ets.dao.stateJobCategory;

import java.util.List;

import com.ets.model.StateJobCategory;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateJobCategoryDAO Interface
 *Description: StateJobCategory Entity DAO Interface
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface StateJobCategoryDAO {
	
	public void addStateJobCategory(StateJobCategory stateJobCategory);
	
	public List<StateJobCategory> stateJobCategoryList();
	
	public void updateStateJobCategory(StateJobCategory stateJobCategory);
	
	public StateJobCategory getByStateJobCategoryID(Integer id);
	
	public void deleteStateJobCategory(Integer id);

}
