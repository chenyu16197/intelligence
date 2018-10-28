<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>编程马拉松时间标准化</title>
	<link rel="stylesheet" type="text/css" href="css/home.css">
	<script src="scripts/jquery.js" type="text/javascript"></script>
	<script src="scripts/jquery.min.js" type="text/javascript"></script>
	<script src="scripts/ajaxfileupload.js" type="text/javascript"></script>
	<script src="js/jquery.pagepiling.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/intelligence.js" type="text/javascript"></script>
</head>
<body>
	<!-- 头部 -->
	<div class="nav header">
		<div class="nav-content">
			<h1 style="width: 220px" class="left" href="#"></h1>
			<span style="color:#1166a7;">编程马拉松</span>
			<div class="right line-li">
				<ul>
					<!-- <li><a href="#">时间转换</a></li> -->
	                <!-- <li><a href="function.html">功能介绍</a></li>
	                <li><a href="case.html">客户案例</a></li>
	            	<li><a href="about.html">关于我们</a></li>
					<li><a href="login.html">登录后台</a></li>
					<li><a href="register.html">申请注册</a></li>
	                <li><a href="help.html">帮助中心</a></li> -->
				</ul>
			</div>
		</div>
	</div>
	<div class="main-content">
		<form class="login" method="post" action="">
			<table class="" width="900" height="400" align="center" cellspacing="10">
				<tbody>
					<tr>
						<td width="115" rowspan="6">&nbsp;
							
					  </td>
						<td width="413" height="21">&nbsp;
							
					  </td>
						<td rowspan="6" width="99">&nbsp;
							
					  </td>
					</tr>
					<tr>
						<td height="46">
							<!-- 自然语言:&nbsp;&nbsp; -->
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input autocomplete="off" class="input" style="width: 220px;" id="jrTime" name="jrTime" type="text" name="username" maxlength="50" placeholder="请输入与时间相关的自然语言">
						</td>
					</tr>
					<!-- <tr>
						<td height="46">
							密　码&nbsp;&nbsp;
							<input class="input" type="password" name="password" placeholder="请输入密码">
						</td>
					</tr> -->
					<tr>
						<td height="36">
							<p>
								<input id="jrTime" name="jrTime" type="button" class="button" value="提交" onclick="doSumbit()">
							</p>
						</td>
					</tr>
					<tr>
						<td height="36">
							<p>
								<input id="load" name="load" type="button" class="button" value="下载模板" onclick="loadExcel()">
							</p>
						</td>
					</tr>
					<tr>
						<td height="46">
							<input type="button" class="button" onclick="uploadFile()" value="批量导入"/>
						</td>
					</tr>
					<tr>
						<td width="450" height="100" style="line-height:26px;">
							<label id="label"></label>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<form id="uploadForm" enctype="multipart/form-data" method="POST">
			<input type="file" name="uploadFile" id="uploadFile" style="visibility:hidden;position:absolute;top:0px;width:0px"/>
			<input type="reset" id="clearForm" name="reset" style="display: none;" />
		</form>
	</div>
	<!-- foot -->
	<div class="footer" style="bottom:0;">
		<div class="foot-menu">
			<!-- <p>
				<a href="#">网站首页</a>&nbsp;|&nbsp;
				<a href="#" target="_blank">申请入驻</a>&nbsp;|&nbsp;
				<a href="#" target="_blank">渠道代理</a>&nbsp;|&nbsp;
				<a href="#" target="_blank">接口定制</a>&nbsp;|&nbsp;
				<a href="#" target="_blank">微信托管</a>&nbsp;|&nbsp;
				<a href="#" target="_blank">关于我们</a>
			</p> -->
			<p>实践是最好的成长，发表是最好的记忆，技术创造价值，恒生技术投稿邮箱：hstech@hundsun.com。</p>
		</div>
		<div class="copyright">Copyright © 1995-2018  恒生电子股份有限公司  版权所有</div>
	</div>

	<script type="text/javascript">
	
	$("body").keydown(function() {
	    if (event.keyCode == "13") {//keyCode=13是回车键；数字不同代表监听的按键不同
	    return false;
	    }
	});
	
	function loadExcel(){
		location.href="excel/input_example.xlsx";
	}
	
	function doSumbit(){
		var ques = $("#jrTime").val();
		if (ques == undefined  || ques == null || ques == ''){
			alert("请先输入！")
		}
		$.ajax({
			url: "answer.html",
			type:"post",
		   dataType: 'json',//返回值类型 一般设置为json
		   contentType: "application/x-www-form-urlencoded; charset=utf-8",
		   data: {
			   "ques":ques
		   },
		   success: function (data){
					$("#label").text(data.msg);
		   }
		})
		
	}
	
	
	  $('#uploadFile').change(function () {
	    	$.ajaxFileUpload({
	            url: "importFile.html",
	            async:false,
	            secureuri: false,           //一般设置为false
	            fileElementId: "uploadFile", //文件上传控件的id属性  <input type="file" id="file" name="file" /> 注意，这里一定要有name值   
	                                                    //$("form").serialize(),表单序列化。指把所有元素的ID，NAME 等全部发过去
	            dataType: 'json',//返回值类型 一般设置为json
	            complete: function () {//只要完成即执行，最后执行
	            },
	            success: function (data){
	            	var data = eval("("+data+")");//将json类型字符串转换为json对象
	            	
	            	if (data.success == true || data.success == "true") {
	            		alert(data.msg);
	            		
	            	} else {
	            		alert(data.msg);
	            	}
		            	
	            },
	            error: function (data, status, e)//服务器响应失败处理函数
	            {
	            	alert("导入失败！");
	            }
	        })
	        setTimeout(reloadPage,8000)
	    }); 
	 	function reloadPage(){ 
		 location.reload();
		} 
	
		function setContentTab(name, curr, n) {
		    for (i = 1; i <= n; i++) {
		        var menu = document.getElementById(name + i);
		        var cont = document.getElementById("con_" + name + "_" + i);
		        menu.className = i == curr ? "hover" : "";
		        if (i == curr) {
		            cont.style.display = "block";
		        } else {
		            cont.style.display = "none";
		        }
		    }
		}
	</script>
</body>
</html>