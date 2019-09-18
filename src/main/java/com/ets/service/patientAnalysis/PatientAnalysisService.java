package com.ets.service.patientAnalysis;

import java.util.List;

import com.ets.model.PatientAnalysis;

public interface PatientAnalysisService {
	
	public void add(PatientAnalysis patan);
	public List<PatientAnalysis> viewPatientAnalysisList(Integer companyId);
	public void saveOrUpdate(PatientAnalysis patan);

	public void delete(Integer id);
	//public PatientAnalysis getByRelationId(Integer id);
	//public void view(PatientAnalysis relation);

}
