<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
   <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css/style.css">
  
</head>
<style>
html { 
  background: url(${pageContext.request.contextPath}/resources/images/5.jpg); 
  background-size: cover;
}

body { 
  color: white; 
}
</style>
<style>
.buttonvideo {
  border-radius: 10px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 8px;
  width: 120px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.buttonvideo span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.buttonvideo span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.buttonvideo:hover span {
  padding-right: 25px;
}

.buttonvideo:hover span:after {
  opacity: 1;
  right: 0;
}

.chip {
    margin-left:7%;
    display: inline-block;
    padding: 0 25px;
    height: 50px;
    font-size: 16px;
    line-height: 50px;
    border-radius: 25px;
    background-color: red;
}

.chip img {
    float: left;
    margin: 0 10px 0 -25px;
    height: 50px;
    width: 50px;
    border-radius: 50%;
}


</style>


</head>
<body>

<div  style="margin-top:2%;width:30%;height:10%;background-color:grey">
try  header
</div>
<div style="float:right;margin-right:1%">
<button class="buttonvideo"><span id ="myBtn">Video </span></button>
</div>

 <!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content" style="display: block;">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h2>Modal Header</h2>
    </div>
    <div class="modal-body" data-reveal data-reset-on-close="true">
             <%-- <iframe  width="700" height="450"  src="${pageContext.request.contextPath}/resources/mtr.mp4" frameborder="0" allowfullscreen></iframe> --%>                                
                  <iframe id="myVideoPlay" width="740" height="450" src="https://www.youtube.com/embed/Ood3teygwh8?" frameborder="0" allowfullscreen>
</iframe>
         <%--          <video width="700" height="450" controls id="myVideoPlay" >
                 <source src="${pageContext.request.contextPath}/resources/mtr.mp4" type="video/mp4"  >
                 </video> --%> 

    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div>
</div>

 
<div class="form">
      
      <ul class="tab-group">
       
        <li class="tab active "><a href="#login">Log In</a></li>
		 <li class="tab "><a href="#signup">Sign Up</a></li>
		
      </ul>
      
      <div class="tab-content">
       
        
        <div id="login">   
          <h1>Welcome Back!</h1>
          
          <form name="loginForm" action="${pageContext.request.contextPath}/login" method="post">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
          
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input name="userName" value="" type="text" />
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input name="password" type="password" />
          </div>
          
          <p class="forgot"><a href="#">Forgot Password?</a></p>
          
          <button type="submit" class="button button-block" >Log In</button>
          </form>

        </div>
         <div id="signup">   
          <h1>Sign Up for Free</h1>
          
          <form action="saveUser" method="post" >
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
          <div class="top-row">
            <div class="field-wrap">
              <label>
                First Name<span class="req">*</span>
              </label>
              <input type="text" id="firstName" name="firstName" />
            </div>
        
            <div class="field-wrap">
              <label>
                Last Name<span class="req"></span>
              </label>
              <input type="text" id="lastName" name="lastName"/>
            </div>
          </div>

          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" id="email" name="email" />
          </div>
          
          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
            <input type="password" id="password" name="password" />
          </div>
          
          <button type="submit" class="button button-block">Get Started</button>
          
          </form>

        </div>
      </div><!-- tab-content -->
      
</div> <!-- /form -->
	
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/js/view/index.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/js/view/video.js"></script>
	<div  style="margin-top:10%;margin-left:2%;width:20%;background-color:grey">
	      
	  <img src="${pageContext.request.contextPath}/resources/images/itg.jpg" alt="Avatar" style="width:304px;height:320px;margin:1px">
	 
    </div>
	
	 <div class="chip">
               <img src="${pageContext.request.contextPath}/resources/images/icon-prize.jpg" alt="Person" width="96" height="96">
                 Winner
          </div>
	<div  style="margin-top:11%;width:100%;height:10%;background-color:grey">
try footer
</div>
	
</body>
</html>