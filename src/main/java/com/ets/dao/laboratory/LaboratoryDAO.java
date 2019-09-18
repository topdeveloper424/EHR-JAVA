package com.ets.dao.laboratory;

import java.util.List;

import com.ets.model.Laboratory;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of LaboratoryDAO Interface
 *Description: Laboratory Entity DAO Interface
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public interface LaboratoryDAO {
	
	public void addOrUpdate(Laboratory laboratory );
	
	public List<Laboratory> view();
	
	public void delete(Integer id);
	
	public Laboratory viewByCode(String code);

}
