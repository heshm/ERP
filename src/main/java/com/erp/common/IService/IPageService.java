package com.erp.common.IService;

import java.util.Map;

import com.erp.common.model.Page;

public interface IPageService<T> {
	
	@SuppressWarnings("rawtypes")
	public abstract Page<T> getIndexPage(int pageIndex,Map parmMap);

}
