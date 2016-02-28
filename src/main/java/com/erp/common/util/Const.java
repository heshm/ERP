package com.erp.common.util;

public class Const {
	
	
	//错误信息
	public static final String LOGIN_ERROR_MESSAGE = "用户名或密码错误 !";
	
	
	public static final String DEFAULT_DEPOT_ID = "01";
	
	//入库单据类型
	public static final String DOCKET_TYPE_1 = "1";      //采购入库
	public static final String DOCKET_TYPE_2 = "2";      //生产入库
	
	//出库单据类型
	public static final String DOCKET_TYPE_3 = "3";     //采购退货
	public static final String DOCKET_TYPE_4 = "4";     //领用退库
	
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
	public static final int FIRST_PAGE_INDEX = 1;
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	
	public static final String DEFAULT_EMPTY_STRING = "";
	
	public static final int DEFAULT_DEC_NO = 2;
	
	public static final int BILL_LENGTH = 14;

}
