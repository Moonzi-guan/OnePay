<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%;  float:left}
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
			function delStudent(id){
				var isDel = confirm("您确认要删除吗？");
				if(isDel){
					//要删除
					location.href = "${pageContext.request.contextPath}/deleteStudentInformation?student_sid="+id;
				}
			}

</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>


</head>
<body>
<!--main_top-->
<form method="post" action="${pageContext.request.contextPath }/findStudentInformationByName" >
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：学生信息管理</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
  		<!-- 搜索框实现异步查询 -->
   		 <td width="90%" align="left" valign="middle"  >
	         <div style="position:relative;width:300px;magin-left:61px">
	         <input id="search_1" type="text" name="student_name" value="${param.student_name }" placeholder="按姓名查询"  onkeyup="searchWord(this)"  style="width:180px;">
	         <div id="showDiv" style="display:none;position:absolute;z-index:1000;background:#fff; width:180px;border:1px solid #ccc;">		
			 </div>
			  <button  type="submit" >查询学生信息</button>
			 </div>
	        
         </td>
         
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="${pageContext.request.contextPath}/student_add.jsp" target="mainFrame"  class="add">新增学生信息</a></td>
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th align="center" valign="middle" class="borderright">编号</th>
        <th align="center" valign="middle" class="borderright">学生学号</th>
        <th align="center" valign="middle" class="borderright">学生姓名</th>
        <th align="center" valign="middle" class="borderright">学生卡余额</th>
        <th align="center" valign="middle" class="borderright">是否冻结</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <c:forEach items="${studentList}" var="student" varStatus="vs">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="center" valign="middle" class="borderright borderbottom">${vs.count}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${student.student_sid}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${student.student_name}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${student.student_money}</td>
        <td align="center" valign="middle" class="borderright borderbottom">${student.student_status}</td>
        <td align="center" valign="middle" class="borderbottom">
        <a href="${pageContext.request.contextPath}/findStudentInformationById?student_sid=${student.student_sid}" target="mainFrame"  class="add">查看</a><span class="gray">&nbsp;|&nbsp;</span>
        <a href="javascript:void(0);" target="mainFrame" onFocus="delStudent('${student.student_sid}')" class="add">删除</a></td>
      </tr>
      </c:forEach>
    </table>
    </td>
    </tr>
			<tr>
				 <td align="left" valign="top" class="fenye">8 条数据 1/1 页&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a href="#" target="mainFrame" onFocus="this.blur()">尾页</a></td>
			</tr>
	</table>
</form>
<!-- 完成异步搜索 -->
<script type="text/javascript">
	//移上去（本身的字体颜色是黑色），然后背景变成蓝色
	function overFn(obj){
		$(obj).css("background","#DBEAF9");
	}
	//移出去的时候，让背景颜色重新变成白色
	function outFn(obj){
		$(obj).css("background","#fff");
	}
	//点击的时候查询的连接
	function clickFn(obj){
		//$(obj).html() 相当于innerHTML 意思是在文本框中显示信息
		$("#search_1").val($(obj).html());
		$("#showDiv").css("display","none");
	}

	function searchWord(obj){
		//1、获得输入框的输入的内容
		var word = $(obj).val();
		//2、根据输入框的内容去数据库中模糊查询---List<Student>
		var content = "";
		$.post(
			"${pageContext.request.contextPath}/searchStudentInformation",
			{"word":word},
			function(data){
					//3、将返回的学生姓名 展现在showDiv中
					if(data.length>0){
						for(var i=0;i<data.length;i++){
							content+="<div style='padding:5px;cursor:pointer' onclick='clickFn(this)' onmouseover='overFn(this)' onmouseout='outFn(this)' >"+data[i]+"</div>";
						}
						$("#showDiv").html(content);
						$("#showDiv").css("display","block");
					}
		},
		"Json"
		);
	
	}
</script>
</body>
</html>