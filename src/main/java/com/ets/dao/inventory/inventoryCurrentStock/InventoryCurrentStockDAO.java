package com.ets.dao.inventory.inventoryCurrentStock;

import java.util.List;

import com.ets.model.InventoryDescription;
import com.ets.model.InventoryCurrentStock;

public interface InventoryCurrentStockDAO {
	public void saveOrUpdate(InventoryCurrentStock inventoryCurrentStock);
	public List<InventoryCurrentStock> view();
}
