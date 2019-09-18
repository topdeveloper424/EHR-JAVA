package com.ets.dao.boyZone;

import java.util.List;

import com.ets.model.BodyZone;
import com.ets.model.InjuryCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyZoneDAO Interface
 *Description: BodyZone Entity DAO Interface
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

public interface BodyZoneDAO {
	
	public void addBodyZone(BodyZone bodyZone);
	
	public List<BodyZone> bodyZoneList();
	
	public void updateBodyZone(BodyZone bodyZone);
	
	public BodyZone getbyBodyZoneID(Integer id);
	
	public void deleteBodyZoneCode(Integer id);

}
