<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">/* 
	$(document).ready(function(){alert("비밀번호가 틀렸습니다");}); */
 
	function onLoadEvent() {
	       alert("비밀번호가 틀렸습니다.");
	       location.href="/login" 
	}
	window.onload = onLoadEvent
	 
</script>
</head>
<body>

</body>
</html>