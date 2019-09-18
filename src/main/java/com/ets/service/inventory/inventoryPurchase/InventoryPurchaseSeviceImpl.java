package com.ets.service.inventory.inventoryPurchase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.inventory.InventoryPurchase.InventoryPurchaseDAO;
import com.ets.model.InventoryPurchase;

@Service
@Transactional
public class InventoryPurchaseSeviceImpl implements InventoryPurchaseSevice {
	
	private InventoryPurchaseDAO inventoryPurchaseDAO;

	public void setInventoryPurchaseDAO(InventoryPurchaseDAO inventoryPurchaseDAO) {
	this.inventoryPurchaseDAO = inventoryPurchaseDAO;
}

	@Override
	public void saveOrUpdate(InventoryPurchase inventoryPurchase) {
		inventoryPurchaseDAO.saveOrUpdate(inventoryPurchase);
		
	}

	@Override
	public List<InventoryPurchase> view() {
		// TODO Auto-generated method stub
		return inventoryPurchaseDAO.view();
	}

}
