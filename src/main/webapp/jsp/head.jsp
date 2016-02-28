<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
<script type="text/javascript">
$(document).ready(function(){
	$("#alertModal").on("hidden", function() {
	    $(this).removeData("modal");
	});
});
</script>
</head>

<div class="header">
	<div class="logo">
		<img src="<%=request.getContextPath()%>/img/logo.png" />
	</div>
	<div class="header-right">
		<i class="icon-question-sign icon-white"></i> <a href="#">帮助</a>
		<i class="icon-off icon-white"></i> <a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal">注销</a>
		
		<div id="modal-container-973558" class="modal hide fade" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="width: 300px; margin-left: -150px; top: 30%">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel">注销系统</h3>
			</div>
			<div class="modal-body">
				<p>您确定要注销退出系统吗？</p>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				<a class="btn btn-primary" style="line-height: 20px;" href="<%=request.getContextPath()%>/logout">确定退出</a>
			</div>
		</div>
		
		
		<div id="alertModal" class="modal hide fade" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="width: 300px; margin-left: -150px; top: 30%">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="msgLevel">系统提示</h3>
			</div>
			<div class="modal-body">
		 
				<p>
				  <img align="left" alt="" src="../img/info.png">
				  <s:actionmessage style="list-style: none; font-size:13px"/>
				  <s:actionerror style="list-style: none; font-size:13px ; color:red"/>
				</p>

			</div>
			<div class="modal-footer">
				<button id="msgBtn" class="btn btn-info" data-dismiss="modal" aria-hidden="true">确定</button>
			</div>
		</div>
	</div>
</div>
<s:if test="hasActionErrors()||hasFieldErrors()"> 
  <script language="JavaScript"> 
      $("#msgLevel").text("系统处理失败");
      $("#msgLevel").css("color","#953b39");
      $("#msgBtn").removeClass("btn-info");
      $("#msgBtn").addClass("btn-danger");
      $("#alertModal").modal();
  </script>
</s:if>
<s:if test="hasActionMessages()"> 
  <script language="JavaScript"> 
      $("#alertModal").modal();
  </script>
</s:if>
