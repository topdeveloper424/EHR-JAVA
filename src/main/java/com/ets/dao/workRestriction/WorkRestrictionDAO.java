package com.ets.dao.workRestriction;

import java.util.List;

import com.ets.model.WorkRestriction;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkRestrictionDAO Interface
 *Description: WorkRestriction Entity DAO Interface
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

public interface WorkRestrictionDAO {

	public void add(WorkRestriction workRestriction);

	public List<WorkRestriction> list();

	public void update(WorkRestriction workRestriction);

	public WorkRestriction getByID(Integer id);

	public void delete(Integer id);

}
