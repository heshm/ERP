<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script type="text/javascript">
function productTypeModiFormSubmit(){
	var flag = $("#isUpdate").val();
	if(flag == 1){
		document.productTypeModiForm.action = "productTypeUpdate";
		
	}else{
		document.productTypeModiForm.action = "productTypeInsert";
	}
	if(confirm("输入无误,确认提交?")){
		document.productTypeModiForm.submit();
	}
	
}
</script>
</head>
<div class="title_right">
  <strong>货品资料维护</strong>
</div> 
<div style="margin:center">
  <s:actionmessage class="actionmessage"/>
  <s:actionerror class="actionerror"/>
</div>
<div style="width:600px; margin:auto">
<s:form name="productTypeModiForm" method="post" action="productTypeModi" namespace="/common" theme="simple">
<s:hidden id="isUpdate" name="isUpdate"/>
<table class="table table-bordered">
  <tbody>
    <tr>
      <td align="right">货品类别:</td>
      <td align="left">
        <s:if test="%{isUpdate==1}">
          <span><s:property value="%{productType.productGroup.groupName}"/></span>
          <s:hidden name="productType.groupId" value="%{productType.productGroup.groupId}"/>
        </s:if>
        <s:else>
          <s:select name="productType.groupId" list="%{#session.productGroup}" class="span2" listKey="groupId" listValue="groupName" theme="simple">
          </s:select>
        </s:else>
      </td>
      <td align="right">货品编码:</td>
      <td align="left" colspan="3">
      <s:if test="%{isUpdate==1}">
        <span><s:property value="%{productType.typeId}"/></span>
        <s:hidden name="productType.typeId"/>
      </s:if>
      <s:else>
        <s:textfield name="productType.typeId" cssStyle="width:30px" maxlength="3"/>[*]
      </s:else>
      </td>
    </tr>

    <tr>
      <td align="right">货品名称:</td>
      <td align="left"><s:textfield name="productType.name" class="span2" maxlength="20"/>[*]</td>
      <td align="right">货品规格:</td>
      <td align="left" colspan="3"><s:textfield name="productType.norm" cssStyle="width:60px" maxlength="60"/>[*]</td>
    </tr>
    <tr>
      <td align="right">单位:</td>
      <td align="left"><s:textfield name="productType.unit" cssStyle="width:60px" maxlength="6"/>[*]</td>
      <td align="right">计量小数位数:</td>
      <td align="left" colspan="3"><s:textfield name="productType.decNo" cssStyle="width:50px" maxlength="5"/>[*]</td>
    </tr>
    <tr>
      <td align="right">参考入库单价:</td>
      <td align="left"><s:textfield name="productType.refInPrice" class="span2" maxlength="10"/></td>
      <td align="right">参考出库单价:</td>
      <td align="left" colspan="3"><s:textfield name="productType.refOutPrice" class="span2" maxlength="10"/></td>
    </tr>
    <tr>
      <td align="right">备注:</td>
      <td align="left" colspan="3"><s:textfield name="productType.remark" class="span3" maxlength="30"/></td>
    </tr>
  </tbody>
</table>
</s:form>
<table  class="margin-bottom-20 table  no-border" >
  <tr>
    <td class="text-center">
      <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="productTypeModiFormSubmit();">保存</button> 
      <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px" onclick="history.back();">取消</button> 
    </td>
  </tr>
</table>
</div>


