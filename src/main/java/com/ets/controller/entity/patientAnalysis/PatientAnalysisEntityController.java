package com.ets.controller.entity.patientAnalysis;

import java.util.List;

import com.ets.dao.patientAnalysis.PatientAnalysisDAO;
import com.ets.model.DrugScreenTestResult;
import com.ets.model.PatientAnalysis;
import com.ets.service.patientAnalysis.PatientAnalysisServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PatientAnalysisEntityController {
	
	
	private PatientAnalysisServiceImpl patientAnalysisServiceImpl;
	private ObservableList<PatientAnalysis> observableList;
	
	public PatientAnalysisEntityController(){
		
		patientAnalysisServiceImpl=(PatientAnalysisServiceImpl) Global.context.getBean("patientAnalysisService");
		observableList = FXCollections.observableArrayList();
	}
	
	public void add(PatientAnalysis relation) {
		patientAnalysisServiceImpl.add(relation);
	}
	/*public ObservableList<PatientAnalysis> viewPatientAnalysis(Integer companyId){
		observableList=FXCollections.observableArrayList(patientAnalysisServiceImpl.viewPatientAnalysisList(companyId));
		return observableList;
		
	}*/
	
	public void saveUpdate(PatientAnalysis pat){
		patientAnalysisServiceImpl.saveOrUpdate(pat);
	}
	
	
	
/*	//@Override
	public List<PatientAnalysis> viewpatientAnalysisList(Integer companyId, String patient, int id) {
		// TODO Auto-generated method stub
		return PatientAnalysisDAO.viewpatientAnalysisList(companyId);
		
	}
	*/
	
	
	/*
	public ObservableList<PatientAnalysis> viewPatientId(Integer companyId) {
	  observableList = FXCollections.observableArrayList(patientAnalysisServiceImpl.viewPatientId(companyId));	
		return observableList;
		
	}*/
	
	
	
	
	public PatientAnalysis viewCompany(Integer companyId) {
		  observableList = FXCollections.observableArrayList(patientAnalysisServiceImpl.viewPatientId(companyId));	
			return observableList.get(0);
			
		}
	
	
	
/*	public ObservableList<DrugScreenTestResult> viewDrugScreenByPatientVisitId(Integer companyId) {
    ObservableList<DrugScreenTestResult> observableList1 = FXCollections.observableArrayList();
	observableList1.addAll(PatientAnalysisServiceImpl.viewByPatientVisitAndMedActivity(companyId));
	observableList =	sortingMaxRevision(observableList1);
    System.out.println(observableList.size()+"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
    return observableList;
		
	}*/
	
	
		
	public void delete(Integer id){
		patientAnalysisServiceImpl.delete(id);
	}

		
	}
