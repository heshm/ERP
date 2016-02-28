package com.erp.stm.serviceImpl;

import java.util.Map;

import com.erp.stm.IDAO.IInventoryDAO;
import com.erp.stm.IService.IInventoryService;
import com.erp.stm.model.Inventory;

public class InventoryService implements IInventoryService {
	
	private IInventoryDAO inventoryDAO;

	public IInventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(IInventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	@Override
	public Inventory getOneInventory(Map map) {
		// TODO Auto-generated method stub
		return inventoryDAO.selectOneInventory(map);
	}

}
