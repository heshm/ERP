<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<head>
<script type="text/javascript">
$(document).ready(function(){
	$("#productTypeModiModel").on("hidden", function() {
	    $(this).removeData("modal");
	});
});


</script>
</head>
<div class="title_right">
  <span class="pull-right margin-bottom-5"><a class="btn btn-info btn-small" id="modal-9735581" href="productTypeModiInit?isUpdate=0" role="button"><i class="icon-plus icon-white"></i>新建采购入库单</a></span>
  <strong>
    <s:if test="%{docketType==1}">
              采购入库单查询
    </s:if>
  </strong>
</div>  
<div style="width:900px; margin:auto;">
  <table class="table table-bordered">
    <tr>
      <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">单据号码：</td>
      <td width="23%"><input type="text"  class="span2" value="RK201401010001"  /></td>
      <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">开单开始时间：</td>
      <td width="43%">
        <s:textfield name="startDate" class="laydate-icon span1-1" id="Calendar1" theme="simple"/>
        <span>~</span>
        <s:textfield name="endDate" class="laydate-icon span1-1" id="Calendar2" theme="simple"/>
      </td>
      <td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">审核状态：</td>
      <td><select name="groupId" id="productTypeQuery_groupId" class="span1-1">
        <option value="">请选择</option>
        <option value="01">未审核</option>
        <option value="02">已审核</option>
      </select>
      </td>
    </tr>
  </table>
  <table  class="margin-bottom-20 table  no-border" >
    <tr>
      <td class="text-center"><input type="button" value="查询" class="btn btn-info " style="width:80px;" onclick="queryProductType()"/></td>
    </tr>
  </table>
  <div style="width:900px; height:340px; margin:auto; overflow-y:auto;">
  <table class="table table-bordered table-hover table-striped">
    <tbody>
      <tr align="center">
        <td nowrap="nowrap"><strong>序号</strong></td>
        <td width="70" nowrap="nowrap"><strong>单据类型</strong></td>
        <td nowrap="nowrap"><strong>单据号码</strong></td>
        <td nowrap="nowrap"><strong>制单人</strong></td>
        <td nowrap="nowrap"><strong>审核人</strong></td>
        <td nowrap="nowrap"><strong>审核状态</strong></td>
        <td nowrap="nowrap"><strong>制单日期</strong></td>
        <td nowrap="nowrap"><strong>审核日期</strong></td>
        <td nowrap="nowrap"><strong>备注</strong></td>
        <td width="80" nowrap="nowrap"><strong> 操作 </strong></td>
      </tr>
      <s:set name="sn" value="1"/>
      <s:iterator var="pageData" value="%{page.pageData}">
      <tr align="center">
        <td nowrap="nowrap"><s:property value="#sn"/></td>
        <td nowrap="nowrap">
          <s:if test="%{#pageData.type==1}">采购入库</s:if>
          <s:if test="%{#pageData.type==2}">生产入库</s:if>
        </td>
        <td nowrap="nowrap"><s:property value="#pageData.receiptNo"/></td>
        <td nowrap="nowrap"><s:property value="#pageData.registrant"/></td>
        <td nowrap="nowrap"><s:property value="#pageData.auditor"/></td>
        <td nowrap="nowrap">
          <s:if test="%{#pageData.status==0}"><span style="color:#f00;">未审核</span></s:if>
          <s:if test="%{#pageData.status==1}">已审核</s:if>
        </td>
        <td nowrap="nowrap"><s:date name="#pageData.writeDate" format="yyyy-MM-dd"/></td>
        <td nowrap="nowrap"><s:date name="#pageData.confirmDate" format="yyyy-MM-dd"/></td>
        <td><s:property value="#pageData.remark"/></td>
        <td nowrap="nowrap">
          <a href="javascript:deleteOneProductType('<s:property value="#productType.groupId"/><s:property value="#productType.typeId"/>');">删除</a> 
          <a href="javascript:updateOneProductType('<s:property value="#productType.groupId"/><s:property value="#productType.typeId"/>');">详情</a>
          <a href="javascript:updateOneProductType('<s:property value="#productType.groupId"/><s:property value="#productType.typeId"/>');">审核</a>
          <a href="javascript:updateOneProductType('<s:property value="#productType.groupId"/><s:property value="#productType.typeId"/>');">反审</a></td>
      </tr>
      </s:iterator>       
   
    </tbody>
  </table>
  </div>
</div>
<div class="pagination text-center">
  <ul>
    <li><a href="#">&laquo;</a></li>
    <li><a href="?p=0">上一页</a></li>
    <li><a href="?p=0">1</a></li> 
    <li><a href="?p=1">2</a></li> 
    <li><a href="?p=1">3</a></li> 
    <li><a href="?p=1">4</a></li> 
    <li><a href="?p=1">5</a></li> 
    <li class="disabled"><span>下一页</span></li> 
    <li><a href="?p=1">&raquo;</a></li> 
  </ul>
</div>

<script>
!function(){
laydate.skin('molv');
laydate({elem: '#Calendar1'});
laydate.skin('molv');
laydate({elem: '#Calendar2'});
}();
 
</script>