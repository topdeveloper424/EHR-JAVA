package com.ets.dao.parentEmployerGroup;

import java.util.List;

import com.ets.model.Clinic;
import com.ets.model.ParentEmployerGroup;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ParentEmployerGroupDAO Interface
 *Description: ParentEmployerGroup Entity DAO Interface
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

public interface ParentEmployerGroupDAO {
	
	public void add(ParentEmployerGroup parentEmployerGroup);
	
	public List<ParentEmployerGroup> view();
	
	public void delete(Integer id);

}
