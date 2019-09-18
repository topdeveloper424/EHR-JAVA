package com.ets.service.inventory.inventoryCurrentStock;

import java.util.List;

import com.ets.model.InventoryCurrentStock;

public interface InventoryCurrentStockService {
	public void saveOrUpdate(InventoryCurrentStock inventoryCurrentStock);
	public List<InventoryCurrentStock> view();

}
