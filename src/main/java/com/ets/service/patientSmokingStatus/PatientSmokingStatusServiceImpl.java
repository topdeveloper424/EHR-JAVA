package com.ets.service.patientSmokingStatus;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientSmokingStatusServiceImpl Class
 *Description: PatientSmokingStatus Entity Service class
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
import com.ets.dao.patientSmokingStatus.PatientSmokingStatusDAO;
import com.ets.model.PatientSmokingStatus;

public class PatientSmokingStatusServiceImpl implements PatientSmokingStatusService {
	
	private PatientSmokingStatusDAO patientSmokingStatusDAO;

	public void setPatientSmokingStatusDAO(PatientSmokingStatusDAO patientSmokingStatusDAO) {
		this.patientSmokingStatusDAO = patientSmokingStatusDAO;
	}

	@Override
	public void saveOrUpdate(PatientSmokingStatus patientSmokingStatus) {
		
		patientSmokingStatusDAO.saveOrUpdate(patientSmokingStatus);
		
	}
	

}
