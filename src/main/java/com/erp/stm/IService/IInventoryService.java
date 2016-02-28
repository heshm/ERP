package com.erp.stm.IService;

import java.util.Map;

import com.erp.stm.model.Inventory;

public interface IInventoryService {
	
	public abstract Inventory getOneInventory(@SuppressWarnings("rawtypes") Map map);

}
