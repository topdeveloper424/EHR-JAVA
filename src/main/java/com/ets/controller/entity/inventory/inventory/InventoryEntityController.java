package com.ets.controller.entity.inventory.inventory;

import com.ets.model.Clinician;
import com.ets.model.InventoryDescription;
import com.ets.service.clinician.ClinicianServiceImpl;
import com.ets.service.inventory.inventiory.InventoryServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryEntityController {

	private InventoryServiceImpl inventoryServiceImpl;
	private ObservableList<InventoryDescription> observableList;
	
	
	public InventoryEntityController() {
		inventoryServiceImpl = (InventoryServiceImpl) Global.context.getBean("inventoryService");
	     observableList = FXCollections.observableArrayList();
		}
	
	public void saveOrUpdate(InventoryDescription inventory)
	{
		inventoryServiceImpl.saveOrUpdate(inventory);
		//context.close();
	}
	
	
	public ObservableList<InventoryDescription> view(){
		
		observableList = FXCollections.observableArrayList(inventoryServiceImpl.view());
		
		return observableList;
	}
    public  InventoryDescription getById(Integer id){
         
	  return inventoryServiceImpl.getById(id);
}
	
	}


