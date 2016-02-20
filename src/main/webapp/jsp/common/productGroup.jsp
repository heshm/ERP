<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(document).ready(function(){
	$("#productGroupModiModel").on("hidden", function() {
	    $(this).removeData("modal");
	});
});
function showproductGroupModiModal(){
	$("#productGroupModiModel").modal({
	    remote: "<%=request.getContextPath()%>/common/productGroupModiInit",
	    backdrop: 'static', 
	    keyboard: false
	});
}
function deleteOneProductGroup(groupId){
	if (confirm("确认删除该条记录？")){
		location.href= "productGroupDelete.action?groupId=" + groupId;
	}
}
</script>
</head>
<div class="title_right">
    <span class="pull-right margin-bottom-5"><a class="btn btn-info btn-small" id="modal-9735581" href="javascript:showproductGroupModiModal();" role="button"><i class="icon-plus icon-white"></i>添加货品大类</a></span>
    <strong>货品大类管理</strong>
</div>

<div id="productGroupModiModel" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-100px; top:30%">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h3 id="myModalLabel">货品分类</h3>
  </div>
  <div class="modal-body">
    <!--  
    <table class="table table-bordered">
    <tbody>
    
      <tr>
        <td align="right">类别编码:</td>
        <td align="left"><input name="endTextBox" type="text" id="endTextBox" style="width:30px" maxlength="2"/>[*]</td>
      </tr>
      <tr>
        <td align="right">类别名称:</td>
        <td align="left"><input name="manTextBox" type="text" id="manTextBox" class="span2" maxlength="60"/>[*]</td>
      </tr>
    </tbody>
    </table>
    -->
  </div>
</div>
<div style="width:500px;margin:auto;">
  <table class="table table-bordered table-hover table-striped">
    <s:set name="sn" value="1"/>
    <tbody>
    <tr align="center">
      <td><strong>No</strong></td>
      <td><strong>类别编码</strong></td>
      <td><strong>类别描述</strong></td>
      <td><strong>操作</strong></td>
    </tr>
    <s:iterator var="productGroup" value="%{productGroupList}">
    <tr align="center">
      <td><s:property value="#sn"/></td>
      <td><s:property value="#productGroup.groupId" /></td>
      <td><s:property value="#productGroup.groupName" /></td>
      <td nowrap="nowrap"><a href="javascript:deleteOneProductGroup('<s:property value="#productGroup.groupId"/>');">删除</a></td>
    </tr>
    <s:set var="sn" value="#sn + 1" />  
    </s:iterator>
    </tbody>
  </table>
</div>
</html>