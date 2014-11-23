<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<!--------------------
LOGIN FORM
by: Amit Jakhu
www.amitjakhu.com
--------------------->

<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login Form</title>

<!--STYLESHEETS-->
<link href="${pageContext.request.contextPath}/resources/css/login1-style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
    body {
            
                background:url(${pageContext.request.contextPath}/resources/images/jumpIntro.jpg)no-repeat center center fixed; 
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
    }
  /*  #wrapper {
        filter:alpha(opacity=60); opacity:.6;
    }*/
</style>

<!--SCRIPTS-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<!--Slider-in icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>
<script type="text/javascript">
function check(test){ 
	var ef= test; 

	  if(ef.username.value=="") { 
	        alert('아이디를 입력하세요.'); 
	        ef.username.focus(); 
	        return false; 
	   
	  } 
	  if(ef.password.value=="") {    
	        alert('비밀번호를 입력하세요.'); 
	        ef.password.focus(); 
	        return false; 
	  } 

	ef.submit(); 
	} 
</script>
</head>
<body>

    
<!--WRAPPER-->
<div id="wrapper">

	<!--SLIDE-IN ICONS-->
    <div class="user-icon"></div>
    <div class="pass-icon"></div>
    <!--END SLIDE-IN ICONS-->

    
<!--LOGIN FORM-->
<form name="login-form" class="login-form" action="/login" method="post" onsubmit="check(this);">

	<!--HEADER-->
    <div class="header">
    <!--TITLE--><h1>JUMP.</h1><!--END TITLE-->
    <!--DESCRIPTION--><span>자신만의 알고 있는 맛있는 음식점을 공유하고<br/> 먹고 싶은 음식점을 추천해보세요.</span><!--END DESCRIPTION-->
    </div>
    <!--END HEADER-->
	
	<!--CONTENT-->
    <div class="content">
	<!--USERNAME--><input name="username" type="text" class="input username" placeholder="이메일"   /><!--END USERNAME-->
    <!--PASSWORD--><input name="password" type="password" class="input password" placeholder="비밀번호"  /><!--END PASSWORD-->
    </div>
    <!--END CONTENT-->
    
    <!--FOOTER-->
    <div class="footer">
        <input type="button" class="r-button" value="가입" onclick="location.href='/register'"/>
        <input type="submit" name="submit" class="l-button" value="로그인" />
    </div>    
			
    <!--END FOOTER-->

</form>
<!--END LOGIN FORM-->


        
        
</div>
<!--END WRAPPER-->

<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->

</body>
</html>