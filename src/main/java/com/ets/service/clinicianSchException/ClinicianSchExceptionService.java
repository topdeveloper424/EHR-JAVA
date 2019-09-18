package com.ets.service.clinicianSchException;

import java.util.Date;
import java.util.List;

import com.ets.model.Clinician;
import com.ets.model.ClinicianSchException;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchExceptionService Interface
 *Description: ClinicianSchException Entity Service Interface
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
public interface ClinicianSchExceptionService {
	public void saveOrUpdate(List<ClinicianSchException> clinicianSchExceptions);
	public void saveOrUpdateNoDuplicate(ClinicianSchException clinicianSchExceptions);

	public void delete(Integer id);
	public void deleteBetweenDates(Date st,Date end,Clinician clinician);
	public List<ClinicianSchException> viewProviderSchExcByIdAndDate(Clinician clinician,String stDate,String enDate);
}
