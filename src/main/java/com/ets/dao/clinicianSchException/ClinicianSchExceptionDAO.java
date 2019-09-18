package com.ets.dao.clinicianSchException;

import java.util.Date;
import java.util.List;

import com.ets.model.ClinicClosed;
import com.ets.model.Clinician;
import com.ets.model.ClinicianSchException;
import com.ets.model.Provider;
import com.ets.model.ProviderSchException;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchExceptionDAO Interface
 *Description: ClinicianSchException Entity DAO Interface
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

public interface ClinicianSchExceptionDAO {
	
	public void saveOrUpdate(List<ClinicianSchException> clinicianSchExceptions);
	public void saveOrUpdateNoDuplicate(ClinicianSchException clinicianSchExceptions);

	public void delete(Integer id);
	public void deleteBetweenDates(Date st,Date end,Clinician clinician);
	public List<ClinicianSchException> viewProviderSchExcByIdAndDate(Clinician clinician,String stDate,String enDate);

}
