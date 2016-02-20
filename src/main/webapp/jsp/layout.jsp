<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库管理系统</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/sdmenu.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/laydate/laydate.js"></script>
</head>
<body>
<tiles:insertAttribute name="head"/>   
            
<div id="middle">
<div class="left">
<script type="text/javascript">
    var myMenu;
    window.onload = function() {
	    myMenu = new SDMenu("my_menu");
	    myMenu.init();
    };
</script>
  <tiles:insertAttribute name="menu"/>
</div>
<div class="Switch"></div>
<script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
   });
</script>

  <div class="right"  id="mainFrame">
    <div class="right_cont">
      <ul class="breadcrumb">当前位置：<a href="#">首页</a> <span class="divider">/</span><a href="#">业务处理</a> <span class="divider">/</span>电脑开票</ul>
      <tiles:insertAttribute name="main"/>
    </div>     
  </div>
</div>
    
<!-- 底部 -->
<div id="footer">版权所有：仓库管理 &copy; 2015&nbsp;&nbsp;&nbsp;&nbsp;</div>
    
    

 <script>
!function(){
    laydate.skin('molv');
    laydate({elem: '#Calendar'});
}();
</script>
</body>
</html>