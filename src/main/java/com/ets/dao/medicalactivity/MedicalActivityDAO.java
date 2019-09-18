package com.ets.dao.medicalactivity;

import com.ets.model.MedicalActivity;

import java.util.List;

/**
 *Original Author: Shazarin Farha on Behalf of ETS for Client Company
 *File Creation Date: 09-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalActivityDAO Interface
 *Description: Medical Activity Entity DAO Interface
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

public interface MedicalActivityDAO {
	
	public void addMedicalActivity(MedicalActivity medicalActivity);
	
	public List<MedicalActivity> medicalActivityList();
	
	public void updateMedicalActivity(MedicalActivity medicalActivity);
	
	public MedicalActivity getByMedicalActivityID(Integer id);
	
	public void deleteMedicalActivity(Integer id);
	
	public List<MedicalActivity> viewMedicalActivityById(Integer id);
	
	public MedicalActivity viewByCode(String code);
    
	public MedicalActivity searchByDescription(String descp);
}
