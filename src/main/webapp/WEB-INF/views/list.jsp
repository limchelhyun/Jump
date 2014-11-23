<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		</script>
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
        
        <style type="text/css">	
        	/*이미지 자동 사이즈 지정*/
        	.content img {
        			width: expression(this.width>0?281:true);
					max-width:281px; 
					min-width:281px;
					height: auto;
			}
			
			.rateit img{
				max-width: 1px;
			}
        </style>
		
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
					<form action="/listsearch" method="post">
						<input type="text" name="search" placeholder="오늘의 메뉴?"/><input type="submit" value="" />
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
		<div class="content">
			<div class="wrap">
			 <div id="main" role="main">
			      <ul id="tiles">
			        <!-- These are our grid blocks -->
			        
			        <!-- JumpBoard 게시판 ********************************************************-->
			        <c:forEach var="JumpBoard" items="${JumpBoard}">
			        <li onclick="location.href='/detail?boardNum=${JumpBoard.boardNum}'">
			        	${JumpBoard.boardContent}
			        	<div class="post-info">
			        		<div class="post-basic-info">
				        		<h3><a href="/detail?boardNum=${JumpBoard.boardNum}">${JumpBoard.boardTitle}</a></h3>
				        		<span><a href="#"><label> </label>${JumpBoard.boardArea}</a></span>
				        		<p>${JumpBoard.boardDate}</p>
			        		</div>
			        		<div class="post-info-rate-share">
			        			<div class="rateit">
			        				<c:choose>
									<c:when test="${JumpBoard.boardBest<=10}"><span style="background:url(${pageContext.request.contextPath}/resources/images/0.png) no-repeat 0px 0px;"></span></c:when>
									<c:when test="${JumpBoard.boardBest<=20}"><span style="background:url(${pageContext.request.contextPath}/resources/images/1.png) no-repeat 0px 0px;"></span></c:when>
									<c:when test="${JumpBoard.boardBest<=40}"><span style="background:url(${pageContext.request.contextPath}/resources/images/2.png) no-repeat 0px 0px;"></span></c:when>
									<c:when test="${JumpBoard.boardBest<=80}"><span style="background:url(${pageContext.request.contextPath}/resources/images/3.png) no-repeat 0px 0px;"></span></c:when>
									<c:otherwise><span style="background:url(${pageContext.request.contextPath}/resources/images/4.png) no-repeat 0px 0px;"></span></c:otherwise>
									</c:choose> 
			        			</div>
			        			<div class="post-share">
			        				<span><h4 style="color: #03ADEB;">+${JumpBoard.boardBest}</h4></span>
			        			</div>
			        			<div class="clear"> </div>
			        		</div>
			        	</div>
			        </li>
			        </c:forEach>
			        <!-- JumpBoard 게시판 끝 ********************************************************-->
			        <!-- End of grid blocks --> 
			      </ul>
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

    