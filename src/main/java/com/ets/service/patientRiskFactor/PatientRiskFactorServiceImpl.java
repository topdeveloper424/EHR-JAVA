package com.ets.service.patientRiskFactor;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientRiskFactorServiceImpl Class
 *Description: PatientRiskFactor Entity Service Class
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
import com.ets.dao.patientRiskFactor.PatientRiskFactorDAO;
import com.ets.model.PatientRiskFactor;

public class PatientRiskFactorServiceImpl implements PatientRiskFactorService{
	
	private PatientRiskFactorDAO patientRiskFactorDAO;

	public void setPatientRiskFactorDAO(PatientRiskFactorDAO patientRiskFactorDAO) {
		this.patientRiskFactorDAO = patientRiskFactorDAO;
	}

	@Override
	public void saveOrUpdate(PatientRiskFactor patientRiskFactor) {
		
		patientRiskFactorDAO.saveOrUpdate(patientRiskFactor);
		
	}
	

}
