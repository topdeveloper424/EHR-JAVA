package com.ets.service.inventory.inventoryPurchase;

import java.util.List;

import com.ets.model.InventoryPurchase;

public interface InventoryPurchaseSevice {
	public void saveOrUpdate(InventoryPurchase inventoryPurchase);
	public List<InventoryPurchase> view();

}
