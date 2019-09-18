package com.ets.service.inventory.inventoryCurrentStock;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.inventory.inventoryCurrentStock.InventoryCurrentStockDAO;
import com.ets.model.InventoryCurrentStock;

@Service
@Transactional
public class InventoryCurrentStockServiceImpl implements InventoryCurrentStockService {
	private  InventoryCurrentStockDAO inventoryCurrentStockDAO;

	public void setInventoryCurrentStockDAO(InventoryCurrentStockDAO inventoryCurrentStockDAO) {
		this.inventoryCurrentStockDAO = inventoryCurrentStockDAO;
	}

	@Override
	public void saveOrUpdate(InventoryCurrentStock inventoryCurrentStock) {
		inventoryCurrentStockDAO.saveOrUpdate(inventoryCurrentStock);
		
	}

	@Override
	public List<InventoryCurrentStock> view() {
		
		return inventoryCurrentStockDAO.view();
	}


	
}
