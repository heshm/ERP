<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript">
function productGroupModiFormSubmit(){
	document.productGroupModiForm.submit();
}
</script>
</head>
<s:form name="productGroupModiForm" method="post" action="productGroupModi" namespace="/common" theme="simple">
<table class="table table-bordered">
  <tbody>
    <tr>
      <td align="right">类别编码:</td>
      <td align="left"><s:textfield name="groupId" style="width:30px" maxlength="2"/>[*]</td>
    </tr>
    <tr>
      <td align="right">类别名称:</td>
      <td align="left"><s:textfield name="groupName" class="span2" maxlength="60"/>[*]</td>
    </tr>
</tbody>
</table>
</s:form>
<table  class="margin-bottom-20 table  no-border" >
  <tr>
    <td class="text-center">
      <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="productGroupModiFormSubmit();">保存</button> 
      <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px">取消</button> 
    </td>
  </tr>
</table>