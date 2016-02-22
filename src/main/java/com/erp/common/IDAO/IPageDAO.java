package com.erp.common.IDAO;

import java.util.List;
import java.util.Map;

public interface IPageDAO<T> {

	public abstract <V, K> List<T> selectPageList(Map<K,V> paramMap); 
	
	public abstract <V, K> int selectTotleCount(Map<K,V> paramMap);

}
