package com.ets.dao.clinicSchedule;

import java.util.List;

import com.ets.model.ClinicSchedule;


/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicScheduleDAO Interface
 *Description: Implementation class for ClinicSchedule Interface
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

public interface ClinicScheduleDAO {
	
	public void saveOrUpdate(ClinicSchedule clinicSchedule);
	
	public List<ClinicSchedule> view();
	
	public List<ClinicSchedule> viewClinicScheduleByClinicId(Integer cId);

}
