package com.ets.service.patientName;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientNameServiceImpl Class
 *Description: PatientName Entity Class Interface
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

import com.ets.dao.patientName.PatientNameDAO;
import com.ets.model.PatientName;

@Service
@Transactional
public class PatientNameServiceImpl implements PatientNameService {
	private PatientNameDAO patientNameDAO;

	public void setPatientNameDAO(PatientNameDAO patientNameDAO) {
		this.patientNameDAO = patientNameDAO;
	}

	@Override
	public void saveOrUpdate(PatientName patientName) {// save method
		patientNameDAO.saveOrUpdate(patientName);

	}

}
