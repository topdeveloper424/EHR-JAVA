package com.ets.service.clinicianBlockTime;

import java.util.Date;
import java.util.List;

import com.ets.model.ClinicBlockSchedule;
import com.ets.model.Clinician;
import com.ets.model.ClinicianBlockTime;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianBlockTimeService Interface
 *Description: ClinicianBlockTime Entity Service Interface
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
public interface ClinicianBlockTimeService {

	
	public void saveOrUpdate(List<ClinicianBlockTime> clinicianBlockTimes);
	public List<ClinicianBlockTime> viewByDate(List<Date> date,Clinician clinician);

	public void delete(List<ClinicianBlockTime> providerBlockTime);
	public void deleteBlockTimeByDate(Date stD,Date enD,Clinician clinician);

}
