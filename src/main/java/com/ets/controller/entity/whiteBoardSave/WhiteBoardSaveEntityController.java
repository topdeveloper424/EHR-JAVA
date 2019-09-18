package com.ets.controller.entity.whiteBoardSave;

import com.ets.model.Tpa;
import com.ets.model.WhiteboardSave;
import com.ets.service.carrier.CarrierServiceImpl;
import com.ets.service.whiteBoardSave.WhiteBoardSaveService;
import com.ets.service.whiteBoardSave.WhiteBoardSaveServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class WhiteBoardSaveEntityController {

	private WhiteBoardSaveServiceImpl whiteBoardSaveServiceImpl; 
	private ObservableList<WhiteboardSave> observableList;
	public void setWhiteBoardSaveService(WhiteBoardSaveService whiteBoardSaveService) {
		this.whiteBoardSaveServiceImpl = whiteBoardSaveServiceImpl;
	}
	
	public WhiteBoardSaveEntityController() {

		
		whiteBoardSaveServiceImpl = (WhiteBoardSaveServiceImpl) Global.context.getBean("whiteBoardSaveService");
		observableList = FXCollections.observableArrayList();

	}

	public void saveOrUpdate(WhiteboardSave whiteboardSave){
		
		whiteBoardSaveServiceImpl.saveOrUpdate(whiteboardSave);
		
	}

    public ObservableList<WhiteboardSave> view(){
		
		observableList = FXCollections.observableArrayList(whiteBoardSaveServiceImpl.view());
		//this.closeApplicationContext();
		return observableList;
		
	}
	
}
