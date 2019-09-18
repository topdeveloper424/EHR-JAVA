package com.ets.dao.patientAnalysis;

import java.util.List;

import com.ets.model.PatientAnalysis;

public interface PatientAnalysisDAO {

	public void add(PatientAnalysis patientAnalysis);
	//public List<PatientAnalysis> viewPatientAnalysisList(Integer companyID);
	public void saveOrUpdate(PatientAnalysis patientAnalysis);
	//public PatientAnalysis getByRelationId(Integer id);
	public void delete(Integer id);
	//public void view(PatientAnalysis patientAnalysis);
	//List<PatientAnalysis> viewpatientAnalysisList(Integer companyId);
/*	static List<PatientAnalysis> viewPatient(Integer companyId) {
		// TODO Auto-generated method stub
		return null;*/

	 List<PatientAnalysis> viewPatientId(Integer companyId);
	}

