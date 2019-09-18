package com.ets.dao.inventory.inventory;

import java.util.List;

import com.ets.model.InventoryDescription;

public interface InventoryDAO {

	public void saveOrUpdate(InventoryDescription inventory);
	public List<InventoryDescription> view();
	public InventoryDescription getById(Integer id);
}
