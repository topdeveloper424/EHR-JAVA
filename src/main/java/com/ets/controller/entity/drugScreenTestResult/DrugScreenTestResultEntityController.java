package com.ets.controller.entity.drugScreenTestResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ets.model.Division;
import com.ets.model.DrugScreenDrugName;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.service.drugScreenTestResult.DrugScreenTestResultServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DrugScreenTestResultEntityController {
	
	private DrugScreenTestResultServiceImpl drugScreenTestResultServiceImpl;
	
	private ObservableList<DrugScreenTestResult> observableList;

	public DrugScreenTestResultEntityController() {
		
		drugScreenTestResultServiceImpl = (DrugScreenTestResultServiceImpl) Global.context.getBean("drugScreenTestResultService");
		observableList = FXCollections.observableArrayList();
		
	}
	
	public void saveOrUpdate(DrugScreenTestResult drugScreenTestResult){
		
		drugScreenTestResultServiceImpl.saveOrUpdate(drugScreenTestResult);
	}
	
	public ObservableList<DrugScreenTestResult> viewDrugScreenTestResultByPatientId(Integer id) {

		observableList = FXCollections.observableArrayList(drugScreenTestResultServiceImpl.viewByPatient(id));
		//this.closeApplicationContext();
		return observableList;
	}
	
	
	public void deleteDrugScreenResult(Integer id){
		drugScreenTestResultServiceImpl.deleteDrugScreenResult(id);
	}
	
		
	public DrugScreenTestResult viewByPatientId(Integer id){
		
		observableList = FXCollections.observableArrayList(drugScreenTestResultServiceImpl.viewByPatientId(id));
		
		return observableList.get(0);
		
	}
	
	public ObservableList<DrugScreenTestResult> viewDrugScreenByPatientVisitId(Integer patVisitid) {

		observableList = FXCollections.observableArrayList(drugScreenTestResultServiceImpl.viewByPatientVisit(patVisitid));
		//this.closeApplicationContext();
		return observableList;
	}
	
	public ObservableList<DrugScreenTestResult> viewDrugScreenByPatientVisitId(Integer patVisitId , String medCode, Integer drugScreenId) {
		//private int max = 0;
		//observableList = FXCollections.observableArrayList(drugScreenTestResultServiceImpl.viewByPatientVisitAndMedActivity(patVisitId, medCode));
		//this.closeApplicationContext();
	  ObservableList<DrugScreenTestResult> observableList1 = FXCollections.observableArrayList();
		//List<DrugScreenTestResult> revisionDrugs
	   observableList1.addAll(drugScreenTestResultServiceImpl.viewByPatientVisitAndMedActivity(patVisitId, medCode, drugScreenId));
	   observableList =	sortingMaxRevision(observableList1);
		
		System.out.println(observableList.size()+"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
		
		return observableList;
		
	}
	
	public ObservableList<DrugScreenTestResult> sortingMaxRevision(ObservableList<DrugScreenTestResult> revisionDrugs)
	{
		
		  ObservableList<DrugScreenTestResult> observableListMax = FXCollections.observableArrayList();
		if(revisionDrugs!=null){
		Set<String> drugNames =new HashSet<>();
		for(int i=0; i<revisionDrugs.size();i++){
			drugNames.add(revisionDrugs.get(i).getDrugTestName());
		}
		int i=0,k=0; boolean flag = false;
		for (String dgName : drugNames) {
			System.out.println("***************"+drugNames);
		
			for(int j=0;j<revisionDrugs.size();j++){
				
				System.out.println(revisionDrugs.get(j).getRevision()+" "+revisionDrugs.get(j).getDrugTestName());
				if(dgName.equals(revisionDrugs.get(j).getDrugTestName())){
					System.out.println("Neha");
				if(i<=revisionDrugs.get(j).getRevision()){
					System.out.println("Priva");
					
					i=revisionDrugs.get(j).getRevision();
					k=j;
					flag = true;
					System.out.println("*************** index "+k+"  revision "+i);
				}
				
			}
				
			}
			observableListMax.add(revisionDrugs.get(k));
			i=0;k=0;
			//System.out.println(observableList.get(i).getDrugTestName()+"%%%%%%%%%%%%%%%%%%%******************"+drugNames.size());
		}
	}
		return observableListMax;
		
	}
	
	/*public ObservableList<DrugScreenTestResult> sortingMaxRevision2(ObservableList<DrugScreenTestResult> revisionDrugs)
	{
		 ObservableList<DrugScreenTestResult> observableListMax1 = FXCollections.observableArrayList();
		 Set<String> drugNames =new HashSet<>();
		 DrugScreenDrugName drgnames =new DrugScreenDrugName();
		 if(revisionDrugs.get(index))
		 for(int i=0;i<drgnames.size();i++)
		 {
			 if(revisionDrugs.get(i).getMedicalActivityCode().equals(drgnames.getDsType())){
				 drugNames.a
			 }
		 }
		 return observableListMax1;
		 
		 
	}*/
	
	
	public ObservableList<DrugScreenTestResult> viewByDrugScreenDrugName(Integer pVisitid, String medCode, Integer drugScreenId,
			String drugName){
		observableList = FXCollections.observableArrayList(drugScreenTestResultServiceImpl.viewByDrugScreenDrugName(pVisitid, medCode, drugScreenId, drugName));
		
				return observableList;
		
	}
	

}
