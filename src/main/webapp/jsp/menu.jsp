<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div id="my_menu" class="sdmenu">
	<div >
		<span>数据查询</span>
		<a href="查询页面.html">库存查询</a>
		<a href="分理处发货排行榜.html">单据查询</a>
	</div>
	<div class="collapsed">
		<span>入库登记</span>
		 <a href="<%=request.getContextPath()%>/stm/receiptBillInit.action?docketType=1">采购入库</a>
		 <a href="<%=request.getContextPath()%>/stm/receiptBillInit.action?docketType=2">生产入库</a>
	</div>
    
 	<div class="collapsed">
		<span>出库登记</span>
		<a href="<%=request.getContextPath()%>/stm/deliveryBillInit.action?docketType=3">采购退货</a>
		<a href="<%=request.getContextPath()%>/stm/deliveryBillInit.action?docketType=4">领用退库</a>

	</div>
 	<div class="collapsed">
		<span>基础资料</span>
		   <a href="<%=request.getContextPath()%>/common/productGroupInit.action">货品分类</a>
		   <a href="<%=request.getContextPath()%>/common/productTypeInit.action">货品资料</a>
	</div>
 	<div class="collapsed">
		<span>系统设置</span>
		<a href="#">操作员管理</a>
		<a href="#">密码修改</a>

	</div>
</div>
</html>