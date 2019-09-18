package com.ets.dao.visitCategoryGroup;

import java.util.List;

import com.ets.model.VisitCategoryGroup;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitCategoryGroupDAO Interface
 *Description: VisitCategoryGroup Entity DAO Interface
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


public interface VisitCategoryGroupDAO {
	
	public void addVisitCategoryGroup(VisitCategoryGroup visitCategoryGroup );
	
	public List<VisitCategoryGroup> viewVisitCategoryGroup();

}
