package com.ets.service.bodyZone;

import java.util.List;

import com.ets.model.BodyZone;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyZoneService Interface
 *Description: BodyZone Entity Service Interface
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


public interface BodyZoneService {
	
public void addBodyZone(BodyZone bodyZone);
	
	public List<BodyZone> bodyZoneList();
	
	public void updateBodyZone(BodyZone bodyZone);
	
public BodyZone getbyBodyZoneID(Integer id);
	
	public void deleteBodyZoneCode(Integer id);

}
