package com.ets.service.inventory.inventoryOutGo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.inventory.inventoryOutGo.InventoryOutGoDAO;
import com.ets.model.InventoryOutGo;

@Service
@Transactional
public class InventoryOutGoServiceImpl implements InventoryOutGoService {
private InventoryOutGoDAO inventoryOutGoDAO;

	
	public void setInventoryOutGoDAO(InventoryOutGoDAO inventoryOutGoDAO) {
	this.inventoryOutGoDAO = inventoryOutGoDAO;
}

	@Override
	public void saveOrUpdate(InventoryOutGo inventoryOutGo) {
		inventoryOutGoDAO.saveOrUpdate(inventoryOutGo);
		
	}

	@Override
	public List<InventoryOutGo> view() {
		
		return inventoryOutGoDAO.view();
	}

	
}
