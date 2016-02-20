<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common/productType.js"></script> 
<script type="text/javascript">
$(document).ready(function(){
	$("#productTypeModiModel").on("hidden", function() {
	    $(this).removeData("modal");
	});
});
function showProductTypeModiModel(){
	$("#productTypeModiModel").modal({
	    remote: "<%=request.getContextPath()%>/common/productTypeModiInit",
	    backdrop: 'static', 
	    keyboard: false
	});
}
function queryProductType(){
	document.queryForm.submit();
}
</script>
</head>
<div class="title_right">
  <span class="pull-right margin-bottom-5"><a class="btn btn-info btn-small" id="modal-9735581" href="javascript:showProductTypeModiModel();" role="button"><i class="icon-plus icon-white"></i>添加货品类别</a></span>
  <strong>货品资料管理</strong>
</div>  
<div id="productTypeModiModel" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h3 id="myModalLabel">货品类别</h3>
  </div>
  <div class="modal-body">
  </div>
</div>
<div style="width:900px; margin:auto">
  <s:form name="queryForm" method="post" action="productTypeQuery" namespace="/common" theme="simple">
  <table class="table table-bordered">
    <tr>
      <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">货品大类：</td>
      <td width="23%">
        <s:select name="groupId" list="%{#session.productGroup}" class="span2" listKey="groupId" listValue="groupName" theme="simple" headerKey="" headerValue="请选择类别">
        </s:select>
      </td>
      <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">货品名称：</td>
      <td width="23%">
        <s:textfield name="productName" class="span1-1"/>
      </td>
    </tr>
  </table>
  </s:form>
  <table  class="margin-bottom-20 table  no-border" >
    <tr>
      <td class="text-center"><input type="button" value="查询" class="btn btn-info " style="width:80px;" onclick="queryProductType()"/></td>
    </tr>
  </table>
  <table class="table table-bordered table-hover table-striped">
    <tbody>
      <s:set name="sn" value="1"/>
      <tr align="center">
        <td nowrap="nowrap"><strong>序号</strong></td>
        <td width="70" nowrap="nowrap"><strong>货品编码</strong></td>
        <td nowrap="nowrap"><strong>货品名称</strong></td>
        <td nowrap="nowrap"><strong>货品规格</strong></td>
        <td nowrap="nowrap"><strong>货品类别</strong></td>
        <td nowrap="nowrap"><strong>单位</strong></td>
        <td nowrap="nowrap"><strong>入库价</strong></td>
        <td nowrap="nowrap"><strong>出库价</strong></td>
        <td nowrap="nowrap"><strong>小数位数</strong></td>
        <td nowrap="nowrap"><strong>备注</strong></td>
        <td width="80" nowrap="nowrap"><strong> 操作 </strong></td>
      </tr>
      <s:iterator var="productType" value="%{productTypeList}">
      <tr align="center">
        <td nowrap="nowrap"><s:property value="#sn"/></td>
        <td nowrap="nowrap"><s:property value="#productType.groupId"/><s:property value="#productType.typeId"/></td>
        <td nowrap="nowrap"><s:property value="#productType.name"/></td>
        <td nowrap="nowrap"><s:property value="#productType.norm"/></td>
        <td nowrap="nowrap"><s:property value="#productType.productGroup.groupName"/></td>
        <td nowrap="nowrap"><s:property value="#productType.unit"/></td>
        <td nowrap="nowrap"><s:property value="#productType.refInPrice"/></td>
        <td nowrap="nowrap"><s:property value="#productType.refOutPrice"/></td>
        <td nowrap="nowrap"><s:property value="#productType.decNo"/></td>
        <td nowrap="nowrap"><s:property value="#productType.remark"/></td>
        <td nowrap="nowrap"><a href="#">删除</a> <a href="#">编辑</a></td>
      </tr>
      <s:set var="sn" value="#sn + 1" />  
      </s:iterator>
    </tbody>
  </table>
</div>
</html>