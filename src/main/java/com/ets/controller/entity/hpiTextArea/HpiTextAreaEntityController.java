package com.ets.controller.entity.hpiTextArea;

import com.ets.model.EmrChartingTextAreaSave;
import com.ets.model.InventoryDescription;
import com.ets.service.Icd10Codes.Icd10CodesServiceImpl;
import com.ets.service.hpiTextAreaSave.HpiTextAreaServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HpiTextAreaEntityController {

	private HpiTextAreaServiceImpl hpiTextAreaServiceImpl;
	private ObservableList<EmrChartingTextAreaSave> observableList;
	public void setHpiTextAreaServiceImpl(HpiTextAreaServiceImpl hpiTextAreaServiceImpl) {
		this.hpiTextAreaServiceImpl = hpiTextAreaServiceImpl;
	}


	public HpiTextAreaEntityController() {
		hpiTextAreaServiceImpl = (HpiTextAreaServiceImpl) Global.context
				.getBean("hpiTextAreaService");
		
	}
	
	public void saveOrUpdate(EmrChartingTextAreaSave hpiTextAreaSave){
		
		hpiTextAreaServiceImpl.saveOrUpdate(hpiTextAreaSave);
		
	}
  /* public ObservableList<EmrHpiTextAreaSave> view(){
		
		observableList = FXCollections.observableArrayList(hpiTextAreaServiceImpl.view());
		
		return observableList;
	}
	*/
      public ObservableList<EmrChartingTextAreaSave> viewAll(Integer patVisitId){
    	  observableList = FXCollections.observableArrayList(hpiTextAreaServiceImpl.viewAll(patVisitId));
    	  
	   return observableList;
		
	}
}
