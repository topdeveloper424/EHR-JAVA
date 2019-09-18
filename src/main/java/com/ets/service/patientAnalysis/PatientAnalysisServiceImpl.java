package com.ets.service.patientAnalysis;

import java.util.List;

import com.ets.dao.patientAnalysis.PatientAnalysisDAO;
import com.ets.model.PatientAnalysis;

public class PatientAnalysisServiceImpl implements PatientAnalysisService  {
	
	
	private PatientAnalysisDAO patanDAO;
	
		public void setPatanDAO(PatientAnalysisDAO patanDAO) {
		this.patanDAO = patanDAO;
	}

		
	@Override
	public void add(PatientAnalysis patan) {
		
		patanDAO.add(patan);
	}
	
	
	@Override
	public void saveOrUpdate(PatientAnalysis patan) {
		
		patanDAO.saveOrUpdate(patan);
			}

	
	@Override
	public void delete(Integer id) {
		patanDAO.delete(id);		
	}

		
	public static PatientAnalysis viewPatientId(Integer companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientAnalysis> viewPatientAnalysisList(Integer companyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
