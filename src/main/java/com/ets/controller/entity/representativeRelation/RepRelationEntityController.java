package com.ets.controller.entity.representativeRelation;

import com.ets.model.RepresentRelation;
import com.ets.service.representRelation.RepresentRelationServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepRelationEntityController {
	private RepresentRelationServiceImpl representRelationServiceImpl;
	private ObservableList<RepresentRelation> observableList;
	
	public RepRelationEntityController(){
		
		representRelationServiceImpl=(RepresentRelationServiceImpl) Global.context.getBean("repRelClassService");
		observableList = FXCollections.observableArrayList();
	}
	
	public void addrelation(RepresentRelation relation) {
		representRelationServiceImpl.add(relation);
	}
	public ObservableList<RepresentRelation> viewRelation(Integer patId){
		observableList=FXCollections.observableArrayList(representRelationServiceImpl.viewrelationList(patId));
		return observableList;
		
	}
	
	public void saveUpdate(RepresentRelation relation){
		representRelationServiceImpl.saveOrUpdate(relation);
	}
	
	public void delete(Integer id){
		representRelationServiceImpl.delete(id);
	}
	
	/*public RepresentRelation view(RepresentRelation relation){
		return observableList.get(0);
		
	}*/
}
