package com.ets.dao.carrier;

import java.util.List;

import com.ets.model.Carrier;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 21-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CarrierDAO Interface
 *Description: Carrier Entity DAO Interface
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

public interface CarrierDAO {
	
	public void add(Carrier carrier);
	
	public List<Carrier> view(); 
	
	public Carrier viewByCode(String code);
	public void delete(Integer id);

}
