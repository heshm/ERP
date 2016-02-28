<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/btn.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/stm/receiptBillModi.js"></script>
<script type="text/javascript">
function ajaxGetProductTypeList(){
	var groupId=$("#selectGroupId").val(); 
	$.ajax({
		cache:false,   
        url:'<%=request.getContextPath()%>/common/ajaxGetProductTypeList.action',   
        type:'post',   
        dataType:'json',   
        data:{groupId:groupId},   
        success:callBack
	});
}
function callBack(productTypeList){
	if(productTypeList.length > 0){
		$("#groupType").empty();
		for(var i in productTypeList){
		    var name = productTypeList[i].name;
		    var typeId = productTypeList[i].typeId;
		    var str = "<option value='" + typeId + "'>" + name + "</option>";
		    $("#groupType").append(str);
	    }
		$("#guige").val(productTypeList[0].norm);
		$("#danwei").val(productTypeList[0].unit);
		$("#danjia").val(productTypeList[0].refInPrice);
	}else{
		$("#groupType").empty();
		$("#guige").val('');
		$("#danwei").val('');
		$("#danjia").val('');
	}
}
function ajaxGetProductType(){
	var groupId=$("#selectGroupId").val();
	var typeId=$("#groupType").val(); 
	$.ajax({
		cache:false,   
        url:'<%=request.getContextPath()%>/common/ajaxGetProductType.action',   
        type:'post',   
        dataType:'json',   
        data:{groupId:groupId,typeId:typeId},   
        success:setinfo
	});
}
function receiptBillUpdate(){
	//alert($("#data").html());
	document.receiptBillForm.submit();
}

</script>
</head>
<div class="title_right">
    <s:if test="%{#session.docketType==3}">
        <strong>采购退货单填写</strong>

    </s:if>
	<s:if test="%{#session.docketType==4}">
       <strong>领用退库单填写</strong>
    </s:if>
</div>
<div style="width: 900px; margin: auto;">
    <s:form name="receiptBillForm" method="post" action="receiptBillModi" namespace="/stm" theme="simple">
	<table class="table table-bordered">
		<tr>
			<td width="12%" align="right" nowrap="nowrap"bgcolor="#f1f1f1">单号：</td>
			<td width="38%">
			  
			    <span>CK201401010001</span>
		
			</td>
			
			<td width="12%" align="right" nowrap="nowrap"bgcolor="#f1f1f1">制单日期：</td>
			<td width="38%">2016-02-02</td>	
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">领用人：</td>
			<td><s:textfield name="receiptBillForm.receipt.enterDate" class="laydate-icon span1-1" id="Calendar2" /></td>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">出库日期：</td>
			<td><s:textfield name="receiptBillForm.receipt.enterDate" class="laydate-icon span1-1" id="Calendar2" /></td>
			
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">供应商：</td>
			<td><s:textfield name="receiptBillForm.receipt.enterDate" class="span4"/></td>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">用途：</td>
			<td><s:textfield name="receiptBillForm.receipt.enterDate" class="span4"/></td>
			
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">备注：</td>
			<td colspan="3"><s:textfield name="receiptBillForm.receipt.remark" class="span8" /></td>
		</tr>
	</table>
	<table class="table table-bordered">
	  <thead>
	     <tr>
	      <td>
	        <a class="btn btn-mini btn-primary add">添加</a>
	      </td>
		  <td colspan="2">
		   
		    <a class="btn btn-mini btn-danger del">删除</a>
		  </td>
		  <td>
		    <a class="btn btn-mini btn-primary">发票扫描件上传</a>
		  </td>
		</tr>
		<tr>
		    <td align="center" bgcolor="#f1f1f1"><input id="checkAll" type="checkbox">全选</td>
			<td align="center" bgcolor="#f1f1f1"><strong>序号</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>货品编码</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>货品名称</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>货品类别</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>品牌名称</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>货品规格</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>数量</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>单位</strong></td>
			<td align="center" bgcolor="#f1f1f1"><strong>单价</strong></td>
            <td align="center" bgcolor="#f1f1f1"><strong>金额</strong></td>
            <td align="center" bgcolor="#f1f1f1"><strong>税率</strong></td>
            <td align="center" bgcolor="#f1f1f1"><strong>税额</strong></td>
		</tr>
	  </thead>
	  <tbody id="data">
		<s:set name="sn" value="1"/>
		<s:iterator var="dataList" value="%{receiptBillForm.receiptDetail}" status="stat">
		<tr>
		    <td align="center"><input type="checkbox"></td>
			<td align="center"><s:property value="#sn"/></td>
			<td align="center">
			  <s:property value="#dataList.commodityType"/>
			  <s:hidden name="receiptBillForm.receiptDetail[%{#stat.index}].commodityType"/>
			</td>
			<td align="center"><s:property value="#dataList.productType.name"/></td>
			<td align="center"><s:property value="#dataList.productType.productGroup.groupName"/></td>
		    <td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].brand" id="input6" class="span1 text-center"/></td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].norm" id="input6" class="span1 text-center"/></td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].quantity" id="input8" class=" span1 text-center"/></td>
			<td align="center"><s:property value="#dataList.productType.unit"/></td>
		    <td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].unitPrice" id="input8" class=" span1 text-center"/></td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].amount" id="input8" class=" span1-1 text-center"/></td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].taxRate" id="input8" class=" span1 text-center"/>%</td>
			<td align="center"><s:textfield name="receiptBillForm.receiptDetail[%{#stat.index}].taxAmt" id="input8" class=" span1-1 text-center"/></td>
            
		</tr>
		<s:set var="sn" value="#sn + 1"/>
		</s:iterator>
	  </tbody>
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
			   <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="receiptBillUpdate();">保存</button> 
               <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="location.href='receiptBillInit.action?docketType=<s:property value="%{docketType}"/>';">取消</button> 
			</td>
		</tr>
	</table>
	
	<div id="addDetailModal" class="modal hide fade" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="width: 500px; margin-left: -220px; top: 25%">
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">货品添加</h3>
		</div>
		<div class="modal-body">
		 <table class="table table-bordered">
        
     
         <tr>
           <td align="right">货品类别:</td>
           <td align="left">
             <s:select id="selectGroupId" name="groupId" list="%{#session.productGroup}" class="span2" 
             listKey="groupId" listValue="groupName" theme="simple" 
             headerKey="" headerValue="请选择类别" onchange="ajaxGetProductTypeList()"/>
           </td>
           <td align="right">货品名称:</td>
           <td align="left" >
             <select id="groupType" class="span2" onchange="ajaxGetProductType()">
                 <option value="">请选择货品</option>
             </select>
           </td>
         </tr>
         <tr>
           <td align="right">品牌名称:</td>
           <td align="left"><input name="endTextBox" type="text" id="pinpaimingcheng" class="span1-1" /></td>
           <td align="right">规格:</td>
           <td align="left" ><input name="endTextBox" type="text" id="guige" class="span1-1" /></td>
         </tr>
         <tr>
           <td align="right">单位:</td>
           <td align="left"><input name="endTextBox" type="text" id="danwei" class="span1-1" readonly="readonly" /></td>
           <td align="right">单价:</td>
           <td align="left"><input name="endTextBox" type="text" id="danjia" class="span1-1" /></td>
         </tr>
         <tr>
           <td align="right">数量:</td>
           <td align="left"><input name="endTextBox" type="text" id="shuliang" class="span1-1" onblur="computeAmt()"/></td>
           <td align="right">金额:</td>
           <td align="left"><span id="jine">0.00</span></td>
         </tr>
         <tr>
           <td align="right">税率:</td>
           <td align="left"><input name="endTextBox" type="text" id="shuilv" class="span1-1" onblur="computeTaxAmt()"/>%</td>
           <td align="right">税额:</td>
           <td align="left"><span id="shuie">0.00</span></td>
         </tr>
         <tr>
           <td align="right">当前库存:</td>
           <td align="left" colspan="3">10000</td>
         </tr>
     </table>
		</div>
		<div class="modal-footer">
		    <a class="btn btn-info" onclick="addNewRow()">添加</a> 
            <button class="btn btn-info" data-dismiss="modal" aria-hidden="true">取消</button> 
	    </div>
	    
    </div>
	<!--  
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		温馨提示：按“Enter”键进行切换；&nbsp;&nbsp;按“F10”保存；&nbsp;&nbsp;按“F5”代收货款；&nbsp;&nbsp;按“F6”返款；
	</div>
	-->

</div>
<script>

(function () { 
	laydate.skin('molv');
    laydate({elem: '#Calendar1'});
    laydate.skin('molv');
    laydate({elem: '#Calendar2'});
}()); 
</script>
