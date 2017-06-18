<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css/home.css">
<div id="sb-site">
	<div id="page-sidebar">
	<div class="row">
	<div class="user_box col-md-12" >
				<div class="user-pic" >
					<c:if test="${empty profPic}">
						<img  src="${pageContext.request.contextPath}/resources/images/vip.jpg" id="dp" />
										
					</c:if>
				</div>
 ${pageContext.request.userPrincipal.name}
<!-- 				<div class="clearfix">&nbsp;</div>
				<div class="clearfix"></div>
 -->				<div class="user_detail_box" >
					<span class="user_Name">
						<!-- <sec:authentication property="principal.username" /> -->
					</span>
					<h4 class="user_mail">
						<!-- <sec:authentication property="principal.name" /> -->
					</h4>
					
					
				</div>
			</div>
	</div>
	<div class="row" style="margin-top: 50px">
	<div class="col-md-12" >
				<img class="mySlides" src="${pageContext.request.contextPath}/resources/images/vip.jpg" style="width:100%; height:50% ">
				  <img class="mySlides" src="${pageContext.request.contextPath}/resources/images/pro.jpg" style="width:100%; height:50%">
				  <img class="mySlides" src="${pageContext.request.contextPath}/resources/images/vip.jpg" style="width:100%; height:50%">
				  <img class="mySlides" src="${pageContext.request.contextPath}/resources/images/pro.jpg" style="width:100%; height:50%">
				
				  <button class="kc-button kc-black kc-display-left" onclick="plusDivs(-1)" style = "margin-right: 15px;margin-left: 15px;">&#10094;</button>
				  <button class="kc-button kc-black kc-display-right" onclick="plusDivs(1)" style = "margin-right: 15px;margin-left: 15px;">&#10095;</button>
			</div>
	</div>
	    <!-----------------------------------------------Code for Left Menu--------------------------------------------------------------------------- -->
<div id="mySidenavRight" class="sidenavRight">
   <a href="#" id="Profile">Profile &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-user" style="font-size:28px;color:white"></i></a>
   <a href="#" id="Winner" class=" "> Winner &nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-trophy" style="font-size:24px;color:yellow"></i></a>
   <a href="#" id="Prize" >Prize &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-diamond" style="font-size:28px"></i></a>
   <a href="#" id="contactUs">Contact &nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-phone" style="font-size:28px;color:red"></i></a>
 
     </div>
		</div>
	</div>
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  console.log(x.length);
  if (n > x.length){
	  slideIndex = 1
	  }    
  if (n < 1){
	  slideIndex = x.length
	  }
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>