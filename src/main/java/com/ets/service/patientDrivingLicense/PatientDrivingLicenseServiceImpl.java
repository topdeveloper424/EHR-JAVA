package com.ets.service.patientDrivingLicense;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientDrivingLicenseServiceImpl Class
 *Description: PatientDrivingLicense Entity Service Class
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
import com.ets.dao.patientDrivingLicense.PatientDrivingLicenseDAO;
import com.ets.model.PatientDrivingLicense;

public class PatientDrivingLicenseServiceImpl implements PatientDrivingLicenseService{

	private PatientDrivingLicenseDAO patientDrivingLicenseDAO;
	
	public void setPatientDrivingLicenseDAO(PatientDrivingLicenseDAO patientDrivingLicenseDAO) {
		this.patientDrivingLicenseDAO = patientDrivingLicenseDAO;
	}

	@Override
	public void saveOrUpdate(PatientDrivingLicense patientDrivingLicense) {
		
		patientDrivingLicenseDAO.saveOrUpdate(patientDrivingLicense);
	}

}
