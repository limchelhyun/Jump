<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
	<head>
		<title>Pinball Website Template | Home :: w3layouts</title>
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>	
		<!----webfonts---->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
		<!----//webfonts---->
		<!-- Global CSS for the page and tiles -->
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
  		<!-- //Global CSS for the page and tiles -->
		<!---start-click-drop-down-menu----->
		<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
        <!----start-dropdown--->
        <script type="text/javascript">
			var $ = jQuery.noConflict();
				$(function() {
					$('#activator').click(function(){
						$('#box').animate({'top':'0px'},500);
					});
					$('#boxclose').click(function(){
					$('#box').animate({'top':'-700px'},500);
					});
				});
				$(document).ready(function(){
				//Hide (Collapse) the toggle containers on load
				$(".toggle_container").hide(); 
				//Switch the "Open" and "Close" state per click then slide up/down (depending on open/close state)
				$(".trigger").click(function(){
					$(this).toggleClass("active").next().slideToggle("slow");
						return false; //Prevent the browser jump to the link anchor
				});
									
			});
		</script>
        <!----//End-dropdown--->
		<!---//End-click-drop-down-menu----->
		

<!-- script 스마트 에디터 -->
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/editor/photo_uploader/popup/attach_photo.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		//전역변수선언
		var editor_object = [];
		
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: editor_object,
			elPlaceHolder: "ir1",
			sSkinURI: "${pageContext.request.contextPath}/resources/editor/SmartEditor2Skin.html",	
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,				
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,		
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
				fOnBeforeUnload : function(){},
			}
		});
		//전송버튼 클릭이벤트
		$("#savebutton").click(function(){
			//id가 smarteditor인 textarea에 에디터에서 대입
			editor_object.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	
			
			//폼 submit
			$("#smartForm").submit();
		})
	})
</script>
<!-- script 스마트 에디터 종료 -->
<!-- style 스마트 에디터 css -->
<style type="text/css">
	#my_align {width:100%;text-align:center;}   
	#my_content {margin:0 auto; /*위에서 센터로 놨음에도 또 이걸 해 주는 건 IE외의 다른 브라우저에선 이게 없으면 다시 왼쪽으로 붙기 때문이에요*/  
			 	 width:750px; /*이건 임의값입니다. 쓰실 데로 수정하세요*/  
             	 text-align:left;}
    #my_content input[type="text"]{
		font-family: "source-sans-pro", Arial, "Helvetica Nueue", Helvetica, sans-serif;
		background-color: #04AEDA;
		-moz-border-radius: 5px;
		-webkit-border-radius: 5px;
		border-radius: 5px;
		border: none;
		display: inline-block;
		color: #EEE;
		font-size: 15px;
		font-weight: 400;
		padding: 10px 12px;
		text-decoration: none;
		margin-bottom:10px;
		-webkit-appearance: none;

		-webkit-transition: all .5s ease-in-out;
		-o-transition: all .5s ease-in-out;
		-moz-transition: all .5s ease-in-out;
		transition: all .5s ease-in-out;
		cursor:pointer;
	}
             	 
    input[type="button"],
	input[type="submit"],.button {
		font-family: "source-sans-pro", Arial, "Helvetica Nueue", Helvetica, sans-serif;
		background-color: #999;
		-moz-border-radius: 5px;
		-webkit-border-radius: 5px;
		border-radius: 5px;
		border: none;
		display: inline-block;
		color: #EEE;
		font-size: 12px;
		font-weight: 400;
		padding: 10px 12px;
		text-decoration: none;
		margin-top: 10px;
		-webkit-appearance: none;
		text-shadow: 0 -1px 0 #666;
		-webkit-transition: all .5s ease-in-out;
		-o-transition: all .5s ease-in-out;
		-moz-transition: all .5s ease-in-out;
		transition: all .5s ease-in-out;
		cursor:pointer;
	}

	input:hover[type="button"],
	input:hover[type="submit"],.button:hover {
		background-color: #009EDE;
		text-decoration: none;
	}
</style>
<!-- 스마트 에디터 css 종료 -->	
</head>
<body>
		<!---start-wrap---->
			<!---start-header---->
			<div class="header">
				<div class="wrap">
				<div class="logo">
					<a href="/list"><img src="${pageContext.request.contextPath}/resources/images/jump.png" title="pinbal" width="150" /></a>
				</div>
				     	  
				<div class="top-searchbar">
					<form>
						<input type="text" placeholder="오늘의 메뉴?"/><input type="submit" value="" />
					</form>
				</div>
                <div class="nav-icon">
					 <a href="#" class="right_bt" id="activator"><span> </span> </a>
				</div>
				 <div class="box" id="box">
					 <div class="box_content">        					                         
						<div class="box_content_center">
						 	<div class="form_content">
								<div class="menu_box_list">
									<ul>
										<li><a href="/list"><span>list</span></a></li>
										<li><a href="/posting"><span>post</span></a></li>
										<li><a href="/logout"><span>logout</span></a></li>	
										<div class="clear"> </div>
									</ul>
								</div>
								<a class="boxclose" id="boxclose"> <span> </span></a>
							</div>                                  
						</div> 	
					</div> 
				</div>    
				<div class="userinfo">
					<div class="user">
						<ul>
							<li><a href="/posting"><span>POST?</span>&nbsp;<img src="${pageContext.request.contextPath}/resources/images/1415545269_MB__plus.png" title="user-name" width="40" /></a></li>
						</ul>
					</div>
				</div>
				<div class="clear"> </div>
			</div>
		</div>
		<!---//End-header---->

<!---start-content---->
<div class="content" style="padding: 30px 0 72px;">
<div class="wrap">
<div id="main" role="main">	
	<!-- 가운데 정렬 div 시작 -->
	<div id="my_align">  
	<div id="my_content">  
	<!-- 가운데 정렬 div 끝 -->
	<form name="smartForm" id="smartForm" action="/posting" method="post">
	<input type="hidden" name="jumpId" value="<%=session.getAttribute("jumpId")%>">
	<table width="100%">
		<tr>
			<td>
			<input type="text" name="area" size="103" maxlength="100" placeholder="지역을 입력해 주세요.">
			</td>
		</tr>	
		<tr>
			<td>
			<input type="text" name="title" size="103" maxlength="100" placeholder="제목을 입력해 주세요.">
			</td>
		</tr>
		<tr>
			<td>
			<textarea name="content" id="ir1" rows="10" cols="100" style="width:740px; height:300px;"></textarea>
			</td>
		</tr>
		<tr>
			<td align="right">
			<input type="button" value="등록" id="savebutton">&nbsp;&nbsp;
			<input type="button" value="취소" onclick="location.href='/list'">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	</form>
	<!-- 가운데 정렬 div 시작 -->
	</div>  
	</div>  
	<!-- 가운데 정렬 div 끝 -->			     
</div>
</div>
</div>
		<!---//End-content---->
		<!----wookmark-scripts---->
		  <script src="${pageContext.request.contextPath}/resources/js/jquery.imagesloaded.js"></script>
		  <script src="${pageContext.request.contextPath}/resources/js/jquery.wookmark.js"></script>
		  <script type="text/javascript">
		    (function ($){
		      var $tiles = $('#tiles'),
		          $handler = $('li', $tiles),
		          $main = $('#main'),
		          $window = $(window),
		          $document = $(document),
		          options = {
		            autoResize: true, // This will auto-update the layout when the browser window is resized.
		            container: $main, // Optional, used for some extra CSS styling
		            offset: 20, // Optional, the distance between grid items
		            itemWidth:280 // Optional, the width of a grid item
		          };
		      /**
		       * Reinitializes the wookmark handler after all images have loaded
		       */
		      function applyLayout() {
		        $tiles.imagesLoaded(function() {
		          // Destroy the old handler
		          if ($handler.wookmarkInstance) {
		            $handler.wookmarkInstance.clear();
		          }
		
		          // Create a new layout handler.
		          $handler = $('li', $tiles);
		          $handler.wookmark(options);
		        });
		      }
		      /**
		       * When scrolled all the way to the bottom, add more tiles
		       */
		      function onScroll() {
		        // Check if we're within 100 pixels of the bottom edge of the broser window.
		        var winHeight = window.innerHeight ? window.innerHeight : $window.height(), // iphone fix
		            closeToBottom = ($window.scrollTop() + winHeight > $document.height() - 100);
		
		        if (closeToBottom) {
		          // Get the first then items from the grid, clone them, and add them to the bottom of the grid
		          var $items = $('li', $tiles),
		              $firstTen = $items.slice(0, 10);
		          $tiles.append($firstTen.clone());
		
		          applyLayout();
		        }
		      };
		
		      // Call the layout function for the first time
		      applyLayout();
		
		      /*// Capture scroll event.
		      $window.bind('scroll.wookmark', onScroll);*/
		    })(jQuery);
		  </script>
		<!----//wookmark-scripts---->
		<!----start-footer--->
		<!-- <div class="footer">
			<p>Design by <a href="http://w3layouts.com/">W3layouts</a></p>
		</div> -->
		<!----//End-footer--->
		<!---//End-wrap---->
	</body>
</html>

