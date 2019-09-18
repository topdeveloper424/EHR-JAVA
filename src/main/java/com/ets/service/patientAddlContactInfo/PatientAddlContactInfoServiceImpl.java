package com.ets.service.patientAddlContactInfo;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientAddlContactInfoServiceImpl Class
 *Description: PatientAddlContactInfo Entity Service class
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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.patientAddlContactInfo.PatientAddlContactInfoDAO;
import com.ets.model.PatientAddlContactInfo;

@Service
@Transactional
public class PatientAddlContactInfoServiceImpl implements PatientAddlContactInfoService {
	
	private PatientAddlContactInfoDAO patientAddlContactInfoDAO;

	public void setPatientAddlContactInfoDAO(PatientAddlContactInfoDAO patientAddlContactInfoDAO) {
		this.patientAddlContactInfoDAO = patientAddlContactInfoDAO;
	}

	@Override
	public void saveOrUpdate(PatientAddlContactInfo patientAddlContactInfo) {
		
		patientAddlContactInfoDAO.saveOrUpdate(patientAddlContactInfo);
		
	}
	

}
