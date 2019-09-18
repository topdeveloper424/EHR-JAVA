package com.ets.controller.entity.buildNote;

import com.ets.model.BuildNote;
import com.ets.model.Provider;
import com.ets.service.buildNote.BuildNoteServiceImpl;
import com.ets.service.provider.ProviderServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BuildNoteEntityController {
	
	

	private BuildNoteServiceImpl buildNoteServiceImpl;
	private ObservableList<BuildNote> observableList;
	private ObservableList<String> observableListString;
	
	public BuildNoteEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		buildNoteServiceImpl = (BuildNoteServiceImpl) Global.context.getBean("buildNoteService");
		observableList = FXCollections.observableArrayList();
		observableListString = FXCollections.observableArrayList();
	}
	
	

	public void saveOrUpdate(BuildNote buildNote){
		
		buildNoteServiceImpl.saveOrUpdate(buildNote);
		//this.closeApplicationContext();
	}
	
	public ObservableList<BuildNote> viewByPatientVisit(Integer patVisitId){
		
		observableList = FXCollections.observableArrayList(buildNoteServiceImpl.viewByPatientVisit(patVisitId));
		////this.closeApplicationContext();
		return observableList;
	}
    public ObservableList<BuildNote> viewByPat(Integer patId){
		
		observableList = FXCollections.observableArrayList(buildNoteServiceImpl.viewByPatient(patId));
		////this.closeApplicationContext();
		return observableList;
	}
	
}
	