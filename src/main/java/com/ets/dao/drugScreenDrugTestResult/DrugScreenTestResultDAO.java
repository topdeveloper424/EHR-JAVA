package com.ets.dao.drugScreenDrugTestResult;

import java.util.Date;
import java.util.List;

import com.ets.model.DrugScreenTestResult;

public interface DrugScreenTestResultDAO {
	
	public void saveOrUpdate(DrugScreenTestResult drugScreenTestResult);
	
	public List<DrugScreenTestResult> view();
	
	public List<DrugScreenTestResult> viewByPatient(Integer id);
	
	public DrugScreenTestResult viewByPatientId(Integer id);
	
	public List<DrugScreenTestResult> viewByPatientVisit(Integer id);
	
	public List<DrugScreenTestResult> viewByPatientVisitAndMedActivity(Integer pVisitid , String medCode, Integer drugScreenId);
	
	public List<DrugScreenTestResult> viewByDrugScreenDrugName(Integer pVisitid, String medCode, Integer drugScreenId, String drugName);
		
	public void deleteDrugScreenResult(Integer id);
	
	

}
