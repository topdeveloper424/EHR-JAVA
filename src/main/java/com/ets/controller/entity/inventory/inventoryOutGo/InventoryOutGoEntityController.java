package com.ets.controller.entity.inventory.inventoryOutGo;

import com.ets.model.InventoryOutGo;
import com.ets.service.inventory.inventoryOutGo.InventoryOutGoServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryOutGoEntityController {

	private InventoryOutGoServiceImpl inventoryOutGoServiceImpl;
	private ObservableList<InventoryOutGo> observableList;

	
	public InventoryOutGoEntityController() {
		inventoryOutGoServiceImpl = (InventoryOutGoServiceImpl) Global.context.getBean("inventoryOutGoService");
		observableList = FXCollections.observableArrayList();
	}
	public void saveOrUpdate(InventoryOutGo inventoryOutGo) {
		inventoryOutGoServiceImpl.saveOrUpdate(inventoryOutGo);
		//context.close();
	}

	
public ObservableList<InventoryOutGo> view(){
		
	observableList = FXCollections.observableArrayList(inventoryOutGoServiceImpl.view());

	//this.closeApplicationConrext();
	return observableList;
}
	

}
