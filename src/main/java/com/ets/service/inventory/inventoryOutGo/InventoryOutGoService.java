package com.ets.service.inventory.inventoryOutGo;

import java.util.List;

import com.ets.model.InventoryOutGo;

public interface InventoryOutGoService {
	public void saveOrUpdate(InventoryOutGo inventoryOutGo);
	public List<InventoryOutGo> view();

}
