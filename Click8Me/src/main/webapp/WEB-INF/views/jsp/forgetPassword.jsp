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
  <title>Forget Password</title>
   <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/css/style.css">
  
</head>

<body> 
			    <div  class="Forgett_password_form" >
                                                <!-- header -->
					<div class="forgetformheader">  
					<center> <b><h1>Find Your Account</h1><b></center>
					</div>
        		      <hr/>
					 <form name="forgetForm" action="${pageContext.request.contextPath}/forgetPassword" method="post">
					<div class="forgetformboby">
				    <h2>Please enter your email address </h2>
					<input type="text" class ="form-control"placeholder="Please Enter your email-id"/></p>
					</div>	
				<hr/>
			<!-- footer -->
			<div class="forgetformfooter">
			<button class="button_submit  submit">Send</button>
		</div>
	</div>

</body>

</html>