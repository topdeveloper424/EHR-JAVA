package com.ets.dao.workActivity;

import java.util.List;

import com.ets.model.WorkActivity;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkActivityDAO Interface
 *Description: WorkActivity Entity DAO Interface
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


public interface WorkActivityDAO {
	
	public void addWorkActivity(WorkActivity workActivity);
	
	public List<WorkActivity> workActivityList();
	
	public void updateWorkActivity(WorkActivity workActivity);
	
	public WorkActivity getByWorkActivityID(Integer id);
	
	public void deleteWorkActivity(Integer id);
	

}
