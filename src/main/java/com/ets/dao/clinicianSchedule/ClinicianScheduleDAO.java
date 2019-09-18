package com.ets.dao.clinicianSchedule;

import java.util.List;

import com.ets.model.ClinicianSchedule;
import com.ets.model.ProviderSchedule;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianScheduleDAO Interface
 *Description: ClinicianSchedule Entity DAO Interface
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

public interface ClinicianScheduleDAO {
     public void saveOrUpdate(ClinicianSchedule clinicianSchedule);
	
	public List<ClinicianSchedule> viewClinicianScheduleId(Integer id);
	
	public List<ClinicianSchedule> view();
	/*public void saveOrUpdate(ClinicianSchedule clinicianSchedule);
	
	public List<ClinicianSchedule> viewClinicianScheduleByClinicianId(Integer cliId);*/
}
