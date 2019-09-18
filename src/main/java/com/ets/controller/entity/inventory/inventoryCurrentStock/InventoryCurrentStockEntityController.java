package com.ets.controller.entity.inventory.inventoryCurrentStock;

import com.ets.model.Contact;
import com.ets.model.InventoryCurrentStock;
import com.ets.service.contact.ContactServiceImpl;
import com.ets.service.inventory.inventoryCurrentStock.InventoryCurrentStockService;
import com.ets.service.inventory.inventoryCurrentStock.InventoryCurrentStockServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryCurrentStockEntityController {

private InventoryCurrentStockServiceImpl inventoryCurrentStockServiceImpl;
private ObservableList<InventoryCurrentStock> observableList;
	
	public InventoryCurrentStockEntityController() {
		inventoryCurrentStockServiceImpl = (InventoryCurrentStockServiceImpl) Global.context.getBean("inventoryCurrentStockService");
		observableList = FXCollections.observableArrayList();
	}
	public void saveOrUpdate(InventoryCurrentStock inventoryCurrentStock) {
		inventoryCurrentStockServiceImpl.saveOrUpdate(inventoryCurrentStock);
		//context.close();
	}

	
public ObservableList<InventoryCurrentStock> view(){
		
	observableList = FXCollections.observableArrayList(inventoryCurrentStockServiceImpl.view());

	//this.closeApplicationConrext();
	return observableList;

}
}
