package com.ets.dao.workLocation;

import java.util.List;

import com.ets.model.WorkLocation;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkLocationDAO Interface
 *Description: WorkLocation Entity DAO Interface
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

public interface WorkLocationDAO {
	
	public void add(WorkLocation workLocation);
	
	public List<WorkLocation> view();
	
	public void delete(Integer id);

}
