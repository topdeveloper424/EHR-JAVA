package com.ets.dao.inventory.InventoryPurchase;

import java.util.List;

import com.ets.model.InventoryOutGo;
import com.ets.model.InventoryPurchase;

public interface InventoryPurchaseDAO {
	public void saveOrUpdate(InventoryPurchase inventoryPurchase);
	public List<InventoryPurchase> view();

}
