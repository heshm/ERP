package com.erp.common.util;

public class Const {
	
	
	//错误信息
	public static final String LOGIN_ERROR_MESSAGE = "用户名或密码错误 !";
	
	
	//入库单据类型
	public static final String DOCKET_TYPE_1 = "1";      //采购入库
	public static final String DOCKET_TYPE_2 = "2";      //生产入库
	
	//单据状态
	public static final String BILL_UNCONFIRM = "0";  //未审核
	public static final String BILL_CONFIRM = "1"; //已审核
	
	
	//更新标志
	public static final Short UPDATE_RECORD = 1;
	public static final Short INSERT_RECORD = 0;
	
	//处理标志
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	
	public static final int DEFAULT_BILL_PAGE_SIZE = 10;

}
