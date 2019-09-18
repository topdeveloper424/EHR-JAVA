package com.ets.service.inventory.inventiory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.inventory.inventory.InventoryDAO;
import com.ets.model.InventoryDescription;

@Service
@Transactional
public class InventoryServiceImpl  implements InventoryService{

	private InventoryDAO inventoryDAO;

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	@Override
	public void saveOrUpdate(InventoryDescription inventory) {
		inventoryDAO.saveOrUpdate(inventory);
		
	}

	@Override
	public List<InventoryDescription> view() {
	
		return inventoryDAO.view();
	}

	@Override
	public InventoryDescription getById(Integer id) {
		
		return inventoryDAO.getById(id);
	}
}
