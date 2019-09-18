package com.ets.dao.illnessCode;

import java.util.List;

import com.ets.model.IllnessCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IllnessCodeDAO Interface
 *Description: IllnessCode Entity DAO Interface
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

public interface IllnessCodeDAO {
	
	public void addIllnessCode(IllnessCode illnessCode);
	
	public List<IllnessCode> illnessCodeList();
	
	public void updateIllnessCode(IllnessCode illnessCode);
	
	public IllnessCode getByIllnessCodeID(Integer id);
	
	public void deleteIllnessCode(Integer id);
	
	

}
