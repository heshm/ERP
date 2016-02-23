<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/btn.css" />
</head>
<div class="title_right">
    <s:if test="%{docketType==1}">
        <strong>采购入库单填写</strong>

    </s:if>
	<s:if test="%{docketType==2}">
       <strong>生产入库单填写</strong>
    </s:if>
</div>
<div style="width: 900px; margin: auto;">
    <s:form theme="simple">
	<table class="table table-bordered">
		<tr>
			<td width="15%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">单号：</td>
			<td width="35%">
			  <span><s:property value="%{receiptBillForm.receipt.receiptNo}"/></span>
			  <s:hidden name="receiptBillForm.receipt.receiptNo"/>
			</td>
			<td width="15%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">制单人：</td>
			<td width="35%"><s:textfield name="receiptBillForm.receipt.registrant" class="span1-1"/></td>
			
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">制单日期：</td>
			<td><s:textfield name="receiptBillForm.writeDate" class="laydate-icon span1-1" id="Calendar1" /></td>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">入库日期：</td>
			<td><s:textfield name="receiptBillForm.confirmDate" class="laydate-icon span1-1" id="Calendar2" /></td>
			
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">审核状态：</td>
			<td><s:select name="receiptBillForm.receipt.status" list="#{'0':'未审核','1':'已审核'}" class="span1-1" theme="simple"/></td>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">供应商：</td>
			<td><s:textfield name="receiptBillForm.receipt.supplier"  class="span4" /></td>
			
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">备注：</td>
			<td colspan="3"><s:textfield name="receiptBillForm.receipt.remark" class="span8" /></td>
		</tr>
	</table>
	<table class="table table-bordered">
	  
		<tr>
			<td align="center" bgcolor="#f1f1f1"><strong>序号</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>货品编码</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>货品名称</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>货品类别</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>货品规格</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>单位</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>数量</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>单价</strong></td>
            <td align="center" bgcolor="#f1f1f1"><strong>金额</strong></td>
            <td align="center" bgcolor="#f1f1f1"><strong>税率</strong></td>
            <td align="center" bgcolor="#f1f1f1"><strong>税额</strong></td>
            <td align="center" bgcolor="#f1f1f1"><strong>操作</strong></td>
		</tr>
		<s:set name="sn" value="1"/>
		<s:iterator var="dataList" value="%{receiptBillForm.receiptDetail}" status="stat">
		<tr>
			<td align="center"><s:property value="#sn"/></td>
			<td align="center"><s:property value="#dataList.commodityType"/></td>
			<td align="center"><s:property value="#dataList.productType.name"/></td>
			<td align="center"><s:property value="#dataList.productType.productGroup.groupName"/></td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].norm" id="input6" class="span1 text-center"/></td>
			<td align="center"><s:property value="#dataList.productType.unit"/></td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].quantity" id="input8" class=" span1 text-center"/></td>
		    <td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].unitPrice" id="input8" class=" span1 text-center"/></td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].amount" id="input8" class=" span1-1 text-center"/></td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].taxRait" id="input8" class=" span1 text-center"/>%</td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].taxAmt" id="input8" class=" span1-1 text-center"/></td>
            <td align="center"><a href="#" class="btn btn-mini btn-danger del">删除</a></td>
            
		</tr>
		<s:set var="sn" value="#sn + 1"/>
		</s:iterator>
		<tr>
		  <td colspan="12"><a class="btn btn-mini btn-primary">添加</a></td>
		</tr>
 
	</table>
	<table class="table table-bordered">
		<tr>
			<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">合计</td>
			<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">总数量：</td>
			<td width="23%"><s:property value="%{receiptBillForm.sumQuantity}"/></td>
			<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">总金额：</td>
			<td><s:property value="%{receiptBillForm.sumAmount}"/></td>
		    <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">总税额：</td>
			<td><s:property value="%{receiptBillForm.sumTaxAmt}"/></td>
		</tr>
	</table>
    </s:form>
	<table class="margin-bottom-20  table no-border">
		<tr>
			<td class="text-center">
			   <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="productTypeModiFormSubmit();">保存</button> 
               <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="history.back();">取消</button> 
			</td>
		</tr>
	</table>
	<!--  
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		温馨提示：按“Enter”键进行切换；&nbsp;&nbsp;按“F10”保存；&nbsp;&nbsp;按“F5”代收货款；&nbsp;&nbsp;按“F6”返款；
	</div>
	-->

</div>
<script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar1'});
laydate.skin('molv');
laydate({elem: '#Calendar2'});
}();
 
</script>
