package com.erp.stm.IDAO;

import java.util.Map;

import com.erp.stm.model.Inventory;

public interface IInventoryDAO {
	
	public static final String INSERT_UPDATE_ONE_INVENTORY = "insertUpdateOneInventory";
	
	public static final String SELECT_ONE_INVENTORY = "selectOneInventory";
	
	public abstract int insertUpdateOneInventory(Inventory inventory);

	public abstract Inventory selectOneInventory(@SuppressWarnings("rawtypes") Map parmMap);
}
