package com.ets.dao.respiratorModel;

import java.util.List;

import com.ets.model.RespiratorModel;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespiratorModelDAO Interface
 *Description: RespiratorModel Entity DAO Interface
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

public interface RespiratorModelDAO {
	
	public void addRespiratorModel(RespiratorModel respiratorModel);
	
	public List<RespiratorModel> viewAllRespiratorModel();
	
	public void delete(Integer id);

}
