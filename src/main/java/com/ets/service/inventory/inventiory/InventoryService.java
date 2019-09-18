package com.ets.service.inventory.inventiory;

import java.util.List;

import com.ets.model.InventoryDescription;

public interface InventoryService {
	public void saveOrUpdate(InventoryDescription inventory);
	public List<InventoryDescription> view();
	public InventoryDescription getById(Integer id);

}
