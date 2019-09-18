package com.ets.service.medicalactivity;

import com.ets.model.MedicalActivity;

import java.util.List;

public interface MedicalActivityService {
	
	public void addMedicalActivity(MedicalActivity medicalActivity);
	
	public List<MedicalActivity> medicalActivityList();
	
	public void updateMedicalActivity(MedicalActivity medicalActivity);
	
	public MedicalActivity getByMedicalActivityID(Integer id);
	
	public void deleteMedicalActivity(Integer id);
	
	public List<MedicalActivity> viewMedicalActivityById(Integer id);
	
	public MedicalActivity viewByCode(String code);
	public MedicalActivity searchByDescription(String descp);
}
