package com.ets.service.clinicianSchException;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicianSchException.ClinicianSchExceptionDAO;
import com.ets.model.Clinician;
import com.ets.model.ClinicianSchException;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchExceptionServiceImpl Class
 *Description: ClinicianSchException Entity Service Class
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
@Service
@Transactional
public class ClinicianSchExceptionServiceImpl implements ClinicianSchExceptionService {
  private ClinicianSchExceptionDAO clinicianSchExceptionDAO;
  
	public void setClinicianSchExceptionDAO(ClinicianSchExceptionDAO clinicianSchExceptionDAO) {
	this.clinicianSchExceptionDAO = clinicianSchExceptionDAO;
}

	@Override
	public void saveOrUpdate(List<ClinicianSchException> clinicianSchExceptions) {
		clinicianSchExceptionDAO.saveOrUpdate(clinicianSchExceptions);
		
	}

	@Override
	public void saveOrUpdateNoDuplicate(ClinicianSchException clinicianSchExceptions) {
		clinicianSchExceptionDAO.saveOrUpdateNoDuplicate(clinicianSchExceptions);
		
	}

	@Override
	public void delete(Integer id) {
		clinicianSchExceptionDAO.delete(id);
		
	}

	@Override
	public void deleteBetweenDates(Date st, Date end, Clinician clinician) {
		clinicianSchExceptionDAO.deleteBetweenDates(st, end, clinician);
		
	}

	@Override
	public List<ClinicianSchException> viewProviderSchExcByIdAndDate(Clinician clinician, String stDate,
			String enDate) {
		// TODO Auto-generated method stub
		return clinicianSchExceptionDAO.viewProviderSchExcByIdAndDate(clinician, stDate, enDate);
	}



}
