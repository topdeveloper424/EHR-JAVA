package com.ets.controller.entity.inventory.inventoryPurchase;

import com.ets.model.InventoryCurrentStock;
import com.ets.model.InventoryPurchase;
import com.ets.service.inventory.inventoryCurrentStock.InventoryCurrentStockServiceImpl;
import com.ets.service.inventory.inventoryPurchase.InventoryPurchaseSeviceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventoryPurchaseEntityController {
	private InventoryPurchaseSeviceImpl inventoryPurchaseSeviceImpl;
	private ObservableList<InventoryPurchase> observableList;

	public InventoryPurchaseEntityController() {
		inventoryPurchaseSeviceImpl = (InventoryPurchaseSeviceImpl) Global.context.getBean("inventoryPurchaseSevice");
		observableList = FXCollections.observableArrayList();
	}

	public void saveOrUpdate(InventoryPurchase inventoryPurchasen) {
		inventoryPurchaseSeviceImpl.saveOrUpdate(inventoryPurchasen);
		// context.close();
	}

	public ObservableList<InventoryPurchase> view() {

		observableList = FXCollections.observableArrayList(inventoryPurchaseSeviceImpl.view());

		// this.closeApplicationConrext();
		return observableList;

	}
}
