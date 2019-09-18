package com.ets.dao.visitCategory;

import java.util.List;

import com.ets.model.VisitCategory;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitCategoryDAO Interface
 *Description: VisitCategory Entity DAO Interface
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

public interface VisitCategoryDAO {
	
	public void addOrUpdate(VisitCategory visitCategory);
	
	public List<VisitCategory> view();
	
	public void delete(Integer id);
	
	public VisitCategory viewByCode(String code);

}
