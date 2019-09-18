package com.ets.service.carrier;

import java.util.List;

import com.ets.model.Carrier;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CarrierService Interface
 *Description: Carrier Entity Service Interface
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

public interface CarrierService {
	
	public void addOrUpdate(Carrier carrier);
	
	public List<Carrier> view();
	
	public Carrier viewByCode(String code);
	public void delete(Integer id);

}
