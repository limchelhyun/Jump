<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

<!--------------------
LOGIN FORM
by: Amit Jakhu
www.amitjakhu.com
--------------------->

<!--META-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login Form</title>

<!--STYLESHEETS-->
<link href="${pageContext.request.contextPath}/resources/css/register-style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
    body {
                
				/*background: #e1c192 url(images/IMG_4799.jpg);*/
                
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
<!-- 폼체크 스크립트 -->
<script type="text/javascript">
function check(test){ 
	var ef= test; 

	  if(ef.userid.value=="") { 
	        alert('이메일을 입력하세요.'); 
	        ef.userid.focus(); 
	        return false; 
	  } 
	  if(ef.password.value=="") {    
	        alert('비밀번호를 입력하세요.'); 
	        ef.password.focus(); 
	        return false; 
	  }
	  if(ef.username.value=="") {    
	        alert('이름을 입력하세요.'); 
	        ef.username.focus(); 
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
<form name="login-form" class="login-form" action="/register" method="post" onsubmit="check(this); return false;">

	<!--HEADER-->
    <div class="header">
    <!--TITLE--><h1>JUMP.</h1><!--END TITLE-->
    <!--DESCRIPTION--><span>먹을 준비 되셨나요?</span><!--END DESCRIPTION-->
    </div>
    <!--END HEADER-->
	
	<!--CONTENT-->
    <div class="content">
	<!--USERNAME--><input name="userid" type="text" class="input userid" placeholder="이메일"  /><!--END USERNAME onfocus="this.value=''"-->
    <!--PASSWORD--><input name="password" type="password" class="input password" placeholder="비밀번호"   /><!--END PASSWORD-->
    <!--USENAME--><input name="username" type="text" class="input username" placeholder="이름"  /><!--USENAME-->
    </div>
    <!--END CONTENT-->
    
    <!--FOOTER-->
    <div class="footer">
        <input type="button" class="r-button" value="로그인" onclick="location.href='/'"/>
        <!--<a href="#" class="r-button">가입</a>  -->  
        <input type="submit" name="submit" class="l-button" value="등록"/>
    </div>    
			
    <!--END FOOTER-->

</form>
<!--END LOGIN FORM-->


        
        
</div>
<!--END WRAPPER-->

<!--GRADIENT--><div class="gradient"></div><!--END GRADIENT-->

</body>
</html>