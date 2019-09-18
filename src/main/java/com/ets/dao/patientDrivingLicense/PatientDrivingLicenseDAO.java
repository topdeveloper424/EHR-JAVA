package com.ets.dao.patientDrivingLicense;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientDrivingLicenseDAO Interface
 *Description: PatientDrivingLicense Entity DAO Interface
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

import com.ets.model.PatientDrivingLicense;

public interface PatientDrivingLicenseDAO {
	
	public void saveOrUpdate(PatientDrivingLicense patientDrivingLicense);

}
