package com.ets.service.medicalActivityCharge;

import java.util.Date;
import java.util.List;

import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientVisit;

public interface MedicalActivityChargeService {
	 public void saveOrUpdate(MedicalActivityCharge medicalActivityCharge);
	// public List<MedicalActivityCharge> viewMedicalActivityCharge();
	 public List<MedicalActivityCharge> viewMedicalActivityCharge(Integer id,Boolean checkBillingStatus);
	 public void delete(Integer id);
	 public List<MedicalActivityCharge> viewByMedicalActivityId(Integer id);
	// public MedicalActivityCharge searchByDateAndOverride(Integer patId,Date fromDate,Date toDate,String Override);
	 public List<MedicalActivityCharge> searchByDateAndOverride(Date fromDate,Date toDate,String Override);
	 public MedicalActivityCharge searchForDrugScreen(Date date,String medicalActivityCode,PatientVisit patientVisit);
	 
	 public List<MedicalActivityCharge> searchByDatePatientBillingStatus(Date date);
	 
	 public List<MedicalActivityCharge> searchByPatientVisit(Integer patientVisitId);
	   public Double getTotalChargeForPatVisit(Integer patVisitId);
	List<MedicalActivityCharge> list();

}
 