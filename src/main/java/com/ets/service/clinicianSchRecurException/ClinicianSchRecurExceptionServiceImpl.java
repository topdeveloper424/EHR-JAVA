package com.ets.service.clinicianSchRecurException;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinicianSchRecurException.ClinicianSchRecurExceptionDAO;
import com.ets.model.ClinicianSchRecurException;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianSchRecurExceptionServiceImpl Class
 *Description: ClinicianSchRecurException Entity Service Class
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
public class ClinicianSchRecurExceptionServiceImpl implements ClinicianSchRecurExceptionService{
     private ClinicianSchRecurExceptionDAO clinicianSchRecurExceptionDAO;
     
	public void setClinicianSchRecurExceptionDAO(ClinicianSchRecurExceptionDAO clinicianSchRecurExceptionDAO) {
		this.clinicianSchRecurExceptionDAO = clinicianSchRecurExceptionDAO;
	}

	public ClinicianSchRecurExceptionServiceImpl() {
		
	}

	@Override
	public void saveOrUpdate(ClinicianSchRecurException clinicianSchRecurException) {
		clinicianSchRecurExceptionDAO.saveOrUpdate(clinicianSchRecurException);
		
	}

	@Override
	public void delete(Integer id) {
		clinicianSchRecurExceptionDAO.delete(id);		
	}

	@Override
	public List<ClinicianSchRecurException> view() {
	
		return clinicianSchRecurExceptionDAO.view();
	}

	@Override
	public List<ClinicianSchRecurException> viewClinicianSchRecurExceptionById(Integer id) {
		
		return clinicianSchRecurExceptionDAO.viewClinicianSchRecurExceptionById(id);
	}

}
