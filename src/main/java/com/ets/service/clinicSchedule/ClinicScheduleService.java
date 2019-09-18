package com.ets.service.clinicSchedule;

import java.util.List;

import com.ets.model.ClinicSchedule;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 02-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicScheduleService Interface
 *Description: ClinicSchedule Entity Service Interface
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
public interface ClinicScheduleService {
	
	public void saveOrUpdate(ClinicSchedule clinicSchedule);
	
	public List<ClinicSchedule> view();
	
	public List<ClinicSchedule> viewClinicScheduleByClinicId(Integer cId);

}
