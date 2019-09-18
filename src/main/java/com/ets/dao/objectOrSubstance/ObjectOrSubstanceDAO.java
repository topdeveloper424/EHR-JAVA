package com.ets.dao.objectOrSubstance;

import java.util.List;

import com.ets.model.ObjectOrSubstance;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ObjectOrSubstanceDAO Interface
 *Description: ObjectOrSubstance Entity DAO Interface
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

public interface ObjectOrSubstanceDAO {
	
	public void addObjectorSubstance(ObjectOrSubstance objectOrSubstance);
	
	public List<ObjectOrSubstance> objectOrSubstanceLists();
	
	public void updateObjectOrSubstance(ObjectOrSubstance objectOrSubstance);
	
	public ObjectOrSubstance getByObjectOrSubstanceID(Integer id);
	
	public void deleteObjectOrSubstance(Integer id);

}
