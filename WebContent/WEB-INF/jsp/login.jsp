<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>宝宝淘论坛登录</title>
		<script src="scripts/jquery.js" type="text/javascript"></script>
		<script src="scripts/jquery.min.js" type="text/javascript"></script>
		<script src="scripts/ajaxfileupload.js" type="text/javascript"></script>
	</head>
	<body>
		<c:if test="${!empty error}">
	        <font color="red"><c:out value="${error}" /></font>
		</c:if>        
		<form action="<c:url value="loginCheck.html"/>"  enctype="multipart/form-data" method="post">
			用户名：
			<input type="text" name="userName">
			
			<input type="file" name="uploadFile"  id="uploadFile"/>
			
			<br>
			密 码：
			<input type="password" name="password">
			<br>
			<input type="submit" value="登录" />
			<input type="reset" value="重置" />
		</form>
	</body>
	<script>
	  $('#uploadFile').change(function () {
	    	$.ajaxFileUpload({
	            url: "importFile.html",
	            secureuri: false,           //一般设置为false
	            fileElementId: "uploadFile", //文件上传控件的id属性  <input type="file" id="file" name="file" /> 注意，这里一定要有name值   
	                                                    //$("form").serialize(),表单序列化。指把所有元素的ID，NAME 等全部发过去
	            dataType: 'json',//返回值类型 一般设置为json
	            complete: function () {//只要完成即执行，最后执行
	            },
	            success: function (data){
	            	alert(data);
	            	var data = eval("("+data+")");//将json类型字符串转换为json对象
	            },
	            error: function (data, status, e)//服务器响应失败处理函数
	            {
	            	alert(e);
	            }
	        })
	    }); 
	</script>
</html>
