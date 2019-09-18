package com.ets.service.clinicianSchedule;

import java.util.List;

import com.ets.model.ClinicianSchedule;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianScheduleService Interface
 *Description: ClinicianSchedule Entity Service Interface
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
public interface ClinicianScheduleService {
	 public void saveOrUpdate(ClinicianSchedule clinicianSchedule);
		
		public List<ClinicianSchedule> viewClinicianScheduleId(Integer id);
		
		public List<ClinicianSchedule> view();
	
	/*public void saveOrUpdate(ClinicianSchedule clinicianSchedule);
	
	public List<ClinicianSchedule> viewClinicianScheduleByClinicianId(Integer cliId);
	*/
}
