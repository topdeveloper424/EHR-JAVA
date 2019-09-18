package com.ets.dao.firstResponse;

import java.util.List;

import com.ets.model.FirstResponse;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of FirstResponseDAO Interface
 *Description: FirstResponse Entity DAO Interface
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

public interface FirstResponseDAO {
	
	public void addFirstResponse(FirstResponse firstResponse);
	
	public List<FirstResponse> firstResponseList();
	
	public void updateFirstResponse(FirstResponse firstResponse);
	
	public FirstResponse getbyFirstResponseID(Integer id);
	
	public void dleteFirstResponse(Integer id);

}
