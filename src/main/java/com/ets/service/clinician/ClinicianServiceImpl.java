package com.ets.service.clinician;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.clinician.ClinicianDAO;
import com.ets.model.Clinician;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicianServiceImpl Class
 *Description: Clinician Entity Service Class
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
public class ClinicianServiceImpl implements ClinicianService {
	
	private ClinicianDAO clinicianDAO;
	
	public void setClinicianDAO(ClinicianDAO clinicianDAO) {
		this.clinicianDAO = clinicianDAO;
	}

	@Override
	public void saveOrUpdate(Clinician clinician) {
		clinicianDAO.saveOrUpdate(clinician);
		
	}

	@Override
	public List<Clinician> view() {
			
		return clinicianDAO.view();
		
	}

	@Override
	public void delete(Integer id) {
		clinicianDAO.delete(id);
		
	}

	@Override
	public Clinician viewById(Integer id) {
				
		return clinicianDAO.viewById(id);
		
	}

	@Override
	public Clinician viewByCode(String code) {
		// TODO Auto-generated method stub
		return clinicianDAO.viewByCode(code);
	}

}
