package com.ets.dao.inventory.inventoryOutGo;

import java.util.List;

import com.ets.model.InventoryOutGo;

public interface InventoryOutGoDAO {
	public void saveOrUpdate(InventoryOutGo inventoryOutGo);
	public List<InventoryOutGo> view();
}


