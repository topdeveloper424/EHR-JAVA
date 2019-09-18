package com.ets.dao.referalProvider;

import java.util.List;

import com.ets.model.ReferalProvider;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReferalProviderDAO Interface
 *Description: ReferalProvider Entity DAO Interface
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

public interface ReferalProviderDAO {
	
	public void addOrUpdate(ReferalProvider referalProvider);
	
	public List<ReferalProvider> view();
	
	public void delete(Integer id);
	
	public ReferalProvider viewById(Integer id);
	
	

}
