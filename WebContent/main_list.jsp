<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>

<script type="text/javascript">

			function delUser(id){
				var isDel = confirm("您确认要删除吗？");
				if(isDel){
					//要删除
					location.href = "${pageContext.request.contextPath}/deluser?id="+id;
				}
			}

</script>


</head>
<body>
<!--main_top-->
<form method="post" action="${pageContext.request.contextPath}/userSearch">
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：用户管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         
	         <span>管理员：</span>
	         <input type="text" name="username" value="${condition.username }" class="text-word">
	         <input  type="submit" value="查询" >
	         
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="${pageContext.request.contextPath}/userpower" target="mainFrame"  class="add">新增管理员</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">管理帐号</th>
        <th align="center" valign="middle" class="borderright">权限</th>
        <th align="center" valign="middle" class="borderright">锁定</th>
        <th align="center" valign="middle" class="borderright">最后登录</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <c:forEach items="${pageBean.userList}" var="user" varStatus="vs" >
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">${vs.count}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.username}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.power}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.lock}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.date}</td>
        <td align="center" valign="middle" class="borderbottom"><a href="${pageContext.request.contextPath}/showuser?id=${user.id}" target="mainFrame"  class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="javascript:void(0);" target="mainFrame" onFocus="delUser('${user.id}')" class="add">删除</a></td>
      </tr>
       </c:forEach>
      <c:forEach items="${userList}" var="user" varStatus="vs">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">${vs.count}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.username}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.power}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.lock}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${user.date}</td>
        <td align="center" valign="middle" class="borderbottom"><a href="${pageContext.request.contextPath}/showuser?id=${user.id}" target="mainFrame"  class="add">编辑</a><span class="gray">&nbsp;|&nbsp;</span><a href="javascript:void(0);" target="mainFrame" onFocus="delUser('${user.id}')" class="add">删除</a></td>
      </tr>
      </c:forEach>
    </table>
    </td>
    </tr>
			<tr>
				<td align="left" valign="top" class="fenye">${pageBean.totalCount }条数据 ${pageBean.currentPage}/${pageBean.totalPage} 页&nbsp;&nbsp; 
				
					<%--首页直接跳转到第一页 --%>
					<a href="${pageContext.request.contextPath }/userlistservlet?currentPage=1" target="mainFrame" >首页</a>&nbsp;&nbsp;
					
					<%--上一页 判断是否是第一页--%>
					<c:if test="${pageBean.currentPage==1 }">
					<a href="javascript:void(0);" target="mainFrame">上一页</a>&nbsp;&nbsp;
					</c:if>
					<c:if test="${pageBean.currentPage!=1 }">
					<a href="${pageContext.request.contextPath }/userlistservlet?currentPage=${pageBean.currentPage-1}" target="mainFrame">上一页</a>&nbsp;&nbsp;
					</c:if>
					
					<%--下一页 判断是否是最后一页--%>
					<c:if test="${pageBean.currentPage==pageBean.totalPage }">
					<a href="javascript:void(0);" target="mainFrame" >下一页</a>
					</c:if>
					<c:if test="${pageBean.currentPage!=pageBean.totalPage }">
					<a href="${pageContext.request.contextPath }/userlistservlet?currentPage=${pageBean.currentPage+1}" target="mainFrame" >下一页</a>
					</c:if>
					
					<%--尾页直接跳转到最后一页 --%>
					<a href="${pageContext.request.contextPath }/userlistservlet?currentPage=${pageBean.totalPage}" target="mainFrame" ">尾页</a>
					
				</td>
			</tr>
	</table>
</form>
</body>
</html>