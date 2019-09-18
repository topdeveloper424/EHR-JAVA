package com.ets.dao.medicalActivityCharge;

import java.util.Date;
import java.util.List;

import com.ets.model.Clinic;
import com.ets.model.MedicalActivity;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientVisit;

public interface MedicalActivityChargeDAO {
	

	 public void saveOrUpdate(MedicalActivityCharge medicalActivityCharge);
	//public List<MedicalActivityCharge> viewMedicalActivityCharge();
	 public void delete(Integer id);
	 public List<MedicalActivityCharge> viewMedicalActivityCharge(Integer id,Boolean checkBillingStatus);
	 public List<MedicalActivityCharge> viewByMedicalActivityId(Integer id);
	// public MedicalActivityCharge searchByDateAndOverride(Integer patId,Date fromDate,Date toDate,String Override);
	 public List<MedicalActivityCharge> searchByDateAndOverride(Date fromDate,Date toDate,String Override);

	 public MedicalActivityCharge searchForDrugScreen(Date date,String medicalActivityCode,PatientVisit patientVisit);
	 
	 public List<MedicalActivityCharge> searchByDatePatientBillingStatus(Date date);
	 
	 public List<MedicalActivityCharge> searchByPatientVisit(Integer patientVisitId);
     public Double getTotalChargeForPatVisit(Integer patVisitId);
   //  public void delete(MedicalActivityCharge medicalActivityCharge);
     public List<MedicalActivityCharge> list();
    // public void remove(MedicalActivityCharge medicalActivityCharge);
     
}
