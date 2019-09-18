package com.ets.dao.entitygroup;

import java.util.List;

import com.ets.model.EntityGroup;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntityGroupDAO Interface
 *Description: EntityGroup Entity DAO Interface
 *Copyright 2016 @Eclipse Techno Consulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface EntityGroupDAO {
	
	public void addOrUpdate(EntityGroup entityGroup);
	
	public List<EntityGroup> view();
	
	public EntityGroup getById(Integer id);
	
	public void delete(Integer id);
	
	

}
