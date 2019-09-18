package com.ets.dao.vitalSignRange;

import java.util.List;

import com.ets.model.VitalSignRange;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VitalSignRangeDAO Interface
 *Description: VitalSignRange Entity DAO class
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

public interface VitalSignRangeDAO {
	
	public void add(VitalSignRange vitalSignRange );
	
	public List<VitalSignRange> list();
	
	public void update(VitalSignRange vitalSignRange );
	
	public VitalSignRange getByID(Integer id);
	
	public void delete(Integer id);

}
