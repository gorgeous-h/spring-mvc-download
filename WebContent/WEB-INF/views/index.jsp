<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Download Demo</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/testDownload">点击下载1</a>&nbsp;&nbsp;
	<button onclick="download()">点击下载2</button>
	<br/><br/>
	<a href="${pageContext.request.contextPath}/downloadEntity">点击下载3</a>&nbsp;&nbsp;
	<button onclick="downloadEntity()">点击下载4</button>
	<script>
		function download(){
			window.location.href = "${pageContext.request.contextPath}/testDownload";
		}
		function downloadEntity(){
			window.location.href = "${pageContext.request.contextPath}/downloadEntity";
		}
	</script>
</body>
</html>