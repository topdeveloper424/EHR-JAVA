package com.ets.service.denialOrShortPayReason;

import java.util.List;

import com.ets.model.DenialOrShortPayReason;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 02-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DenialOrShortPayReasonService Class
 *Description: DenialOrShortPayReason Entity Service Class
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
public interface DenialOrShortPayReasonService {
	
	public void add(DenialOrShortPayReason denialOrShortPayReason);

	public List<DenialOrShortPayReason> list();

	public void update(DenialOrShortPayReason denialOrShortPayReason);

	public DenialOrShortPayReason getByID(Integer id);

	public void delete(Integer id);

}
