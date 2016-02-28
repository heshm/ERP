<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/btn.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/stm/deliveryBillModi.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var status = $("#status").val();
	if(status==1){
		$('form input').each(function(){
			$(this).prop("readonly","readonly");
		});
		$('form a').each(function(){
			$(this).addClass("disabled");
		});

	};

    $('.del').on('click',function(){
    	if(status!=1){
    		//var $_tr = $(this).parents('tr');
    		if (confirm("确定删除选中货品记录？")) { 
    			//var $_tbody = $_tr.parents('tbody');
    			//$_tr.remove(); 
    			//tableResort($_tbody);
    			$("#data").find("input[type='checkbox']").each(function(){
    				if($(this).prop("checked")){
    					var $_tr = $(this).parents('tr');
    					$_tr.remove(); 
    					tableResort($("#data"));
    				}
    			});
    		}
    	}
	});


	$('.add').click(function(){
		if(status!=1){
			$("#addDetailModal").modal();
		}	
	});
	
	$("#addDetailModal").on("hidden", function() {
	    $(this).find("input[type='text']").each(function(){
	    	$(this).val('');
	    });
	});
	
	$("#checkAll").click(function(){
		if(this.checked){
			$("input[type='checkbox']").prop("checked",true);
		}else{
			$("input[type='checkbox']").prop("checked",false);
		}
	})
	
});
function tableResort($obj){
	var i = 0;
	$obj.find('tr').each(function(){
		var j =0;
		$(this).find('td').each(function(){
			var name = "";
			var seqNo = 0;
			if(j==1){
			    seqNo = i + 1;
				seqNo = "" + seqNo;
				$(this).html(seqNo);
			}
		    if((j==2||j==5||j==6||j==7||j>=9)&&j<=12){
		    	$input = $(this).find('input');
		    	name = $input.attr('name');
		    	seqNo = "[" + i + "]";
		    	name = name.replace(/\[.*\]/,seqNo);
		        $input.attr('name',name);
		        
		    }
			j++;
		});
		i++;
	});
}

function setinfo(productType){
	$("#guige").val(productType.norm);
	$("#danwei").val(productType.unit);
	$("#danjia").val(productType.refInPrice);
	
}
function computeAmt(){
	var danjia = $("#danjia").val();
	var shuliang = $("#shuliang").val();
	var jine = danjia * shuliang;
	$("#jine").text(jine);
}
function computeTaxAmt(){
	var danjia = $("#danjia").val();
	var shuliang = $("#shuliang").val();
	var shuilv = $("#shuilv").val();
	var shuie = danjia * shuliang * shuilv / 100;
	$("#shuie").text(shuie);
}
function addNewRow(){
	var groupId=$("#selectGroupId").val();
	var typeId=$("#groupType").val(); 
	if($.trim(groupId).length==0){
		alert("货品类别不能为空!")
		$("#selectGroupId").focus();
		return 0;
	}
	
	if($.trim(typeId).length==0){
		alert("货品名称不能为空!")
		$("#groupType").focus();
		return 0;
	}
	var exist = false;
	var code = groupId + typeId;
	
	$("#data").find('tr').each(function(){
		$td = $(this).children("td");
		var text = $.trim($td.eq(2).text());
		if(text == code){
			var msg = "货品编码为(" + code + ")的记录已经存在!";
			alert(msg);
			exist = true;
			return;
		}	
	});
	
	var hpmc = $("#groupType").find("option:selected").text();
	var hplb = $("#selectGroupId").find("option:selected").text();
	var ppmc = $("#pinpaimingcheng").val();
	var guige = $("#guige").val();
	var danwei = $("#danwei").val();
	var danjia = $("#danjia").val();
	var shuliang = $("#shuliang").val();
	var jine = $("#jine").text();
	var shuilv = $("#shuilv").val();
	var shuie = $("#shuie").text();
  
    var newRow = "<tr>" +
            "<td align='center'><input type='checkbox'></td>" +
			"<td align='center'>1</td>" +
			"<td align='center'>" + code +
			"<input type='hidden' name='deliveryBillForm.deliveryDetailList[0].commodityType' value='" + code + "'/>" +
			"</td>" +
			"<td align='center'>" + hpmc + "</td>" +
			"<td align='center'>" + hplb + "</td>" +
		    "<td align='center'><input type='text' name='deliveryBillForm.deliveryDetailList[0].brand' value='" + ppmc + "' id='input6' class='span1 text-center'/></td>" +
			"<td align='center'><input type='text' name='deliveryBillForm.deliveryDetailList[0].norm' value='" + guige + "' id='input6' class='span1 text-center'/></td>" +
			"<td align='center'><input type='text' name='deliveryBillForm.deliveryDetailList[0].quantity' value='" + danjia + "' id='input8' class=' span1 text-center'/></td>" +
			"<td align='center'>" + danwei + "</td>" +
    	    "<td align='center'><input type='text' name='deliveryBillForm.deliveryDetailList[0].unitPrice' value='" + shuliang + "' id='input8' class=' span1 text-center'/></td>" +
			"<td align='center'><input type='text' name='deliveryBillForm.deliveryDetailList[0].amount' value='" + jine + "' id='input8' class=' span1-1 text-center'/></td>" +
			"<td align='center'><input type='text' name='deliveryBillForm.deliveryDetailList[0].taxRate' value='" + shuilv + "' id='input8' class=' span1 text-center'/>%</td>" +
			"<td align='center'><input type='text' name='deliveryBillForm.deliveryDetailList[0].taxAmt' value='" + shuie + "' id='input8' class=' span1-1 text-center'/></td>" +
      "</tr>";
      //alert(newRow);
    if(!exist){
    	 $("#data").append(newRow);
    	 tableResort($("#data"));
    } 
}
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
		$("#danjia").val(productTypeList[0].refOutPrice);
		ajaxGetInventory();
	}else{
		$("#groupType").empty();
		$("#guige").val('');
		$("#danwei").val('');
		$("#danjia").val('');
		$("#dqkc").text('');
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
function deliveryBillUpdate(){
	//alert($("#data").html());
	document.deliveryBillForm.submit();
}
function ajaxGetInventory(){
	var groupId=$("#selectGroupId").val();
	var typeId=$("#groupType").val(); 
	$.ajax({
		cache:false,   
        url:'<%=request.getContextPath()%>/common/ajaxGetInventory.action',   
        type:'post',   
        dataType:'json',   
        data:{groupId:groupId,typeId:typeId},   
        success:setkucun
	});
}
function setkucun(inventory){
	var quantity = inventory.inQuantity;
	quantity = quantity - inventory.outQuantity;
	quantity = quantity + $("#danwei").val();
	$("#dqkc").text(quantity);
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
    <s:form name="deliveryBillForm" method="post" action="deliveryBillModi" namespace="/stm" theme="simple">
	<s:hidden name="update"/>
	<s:hidden name="deliveryNo"/>
	<s:hidden name="writeDate"/>
	<table class="table table-bordered">
		<tr>
			<td width="12%" align="right" nowrap="nowrap"bgcolor="#f1f1f1">单号：</td>
		    <td width="38%">	 
			    <s:if test="%{update==1}"> 
			      <span><s:property value="%{deliveryBillForm.delivery.deliveryNo}"/></span>
			      <s:hidden name="deliveryBillForm.delivery.deliveryNo" value="%{deliveryNo}"/>
			    </s:if>
			    <s:if test="%{update==0}">
			      <span><s:property value="%{deliveryNo}"/></span>
			      <s:hidden name="deliveryBillForm.delivery.deliveryNo" value="%{deliveryNo}"/>
			    </s:if>
			</td>
			
			<td width="12%" align="right" nowrap="nowrap"bgcolor="#f1f1f1">制单日期：</td>
			<s:if test="%{update==1}"> 
			    <td width="38%"><s:property value="%{deliveryBillForm.delivery.writeDate.substring(0,10)}"/></td>	
			</s:if>
			<s:else>
			    <td width="38%"><span><s:property value="%{writeDate}"/></span></td>	
			</s:else>
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">领用人：</td>
			<td><s:textfield name="deliveryBillForm.delivery.consumer" class="span1-1" /></td>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">出库日期：</td>
			<td><s:textfield name="deliveryBillForm.delivery.outDate" class="laydate-icon span1-1" id="Calendar2" /></td>
			
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">供应商：</td>
			<td><s:textfield name="deliveryBillForm.delivery.supplier" class="span4"/></td>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">用途：</td>
			<td><s:textfield name="deliveryBillForm.delivery.useFor" class="span4"/></td>
			
		</tr>
		<tr>
			<td align="right" nowrap="nowrap" bgcolor="#f1f1f1">备注：</td>
			<td colspan="3"><s:textfield name="deliveryBillForm.delivery.remark" class="span8" /></td>
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
		<s:iterator var="dataList" value="%{deliveryBillForm.deliveryDetailList}" status="stat">
		<tr>
		    <td align="center"><input type="checkbox"></td>
			<td align="center"><s:property value="#sn"/></td>
			<td align="center">
			  <s:property value="#dataList.commodityType"/>
			  <s:hidden name="deliveryBillForm.deliveryDetailList[%{#stat.index}].commodityType"/>
			</td>
			<td align="center"><s:property value="#dataList.productType.name"/></td>
			<td align="center"><s:property value="#dataList.productType.productGroup.groupName"/></td>
		    <td align="center"><s:textfield name="deliveryBillForm.deliveryDetailList[%{#stat.index}].brand" id="input6" class="span1 text-center"/></td>
			<td align="center"><s:textfield name="deliveryBillForm.deliveryDetailList[%{#stat.index}].norm" id="input6" class="span1 text-center"/></td>
			<td align="center"><s:textfield name="deliveryBillForm.deliveryDetailList[%{#stat.index}].quantity" id="input8" class=" span1 text-center"/></td>
			<td align="center"><s:property value="#dataList.productType.unit"/></td>
		    <td align="center"><s:textfield name="deliveryBillForm.deliveryDetailList[%{#stat.index}].unitPrice" id="input8" class=" span1 text-center"/></td>
			<td align="center"><s:textfield name="deliveryBillForm.deliveryDetailList[%{#stat.index}].amount" id="input8" class=" span1-1 text-center"/></td>
			<td align="center"><s:textfield name="deliveryBillForm.deliveryDetailList[%{#stat.index}].taxRate" id="input8" class=" span1 text-center"/>%</td>
			<td align="center"><s:textfield name="deliveryBillForm.deliveryDetailList[%{#stat.index}].taxAmt" id="input8" class=" span1-1 text-center"/></td>
            
		</tr>
		<s:set var="sn" value="#sn + 1"/>
		</s:iterator>
	  </tbody>
	</table>
	<table class="table table-bordered">
		<tr>
			<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">合计</td>
			<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">总数量：</td>
			<td width="23%"><s:property value="%{deliveryBillForm.sumQuantity}"/></td>
			<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">总金额：</td>
			<td><s:property value="%{deliveryBillForm.sumAmount}"/></td>
		    <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">总税额：</td>
			<td><s:property value="%{deliveryBillForm.sumTaxAmt}"/></td>
		</tr>
	</table>
    </s:form>
    
	<table class="margin-bottom-20  table no-border">
		<tr>
			<td class="text-center">
			   <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="deliveryBillUpdate();">保存</button> 
               <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="location.href='deliveryBillInit.action?docketType=<s:property value="%{#session.docketType}"/>';">取消</button> 
			</td>
		</tr>
		<tr>
		    <td class="text-center">
		      <label class="checkbox inline">
		          <input type="checkbox"><span>保存后弹出打印</span>
		      </label>
		     
		    </td>
		</tr>
	</table>
	
	<div class="alert"> 
      <button type="button" class="close" data-dismiss="alert">&times;</button>
             温馨提示：按“TAB”键进行切换；&nbsp;&nbsp;按“F10”保存；&nbsp;&nbsp;
    </div>
	
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
             <select id="groupType" class="span2" onchange="ajaxGetProductType();ajaxGetInventory();">
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
           <td align="right" style="color:#f00;">当前库存:</td>
           <td align="left" colspan="3">
              <span id="dqkc" style="color:#f00;"></span>
           </td>
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
