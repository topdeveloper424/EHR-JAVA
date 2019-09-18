package com.ets.dao.exposureCode;

import java.util.List;

import com.ets.model.ExposureCode;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExposureCodeDAO Interface
 *Description: ExposureCode Entity DAO Interface
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

public interface ExposureCodeDAO {
	
	public void addExposureCode(ExposureCode exposureCode);
	
	public List<ExposureCode> exposureCodeList();
	
	public void updateExposureCode(ExposureCode exposureCode);
	
	public ExposureCode getByExposureCodeID(Integer id);
	
	public void deleteExposureCode(Integer id);

}
