<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<style>
.topnav {
	overflow: hidden;
	position: absolute;
	padding: 0 300 0 260;
	top: 35px
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 12px 40px;
	text-decoration: none;
	font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
	background-color: #4CAF50;
	color: white;
}


.searchBox {
	/* margin-right: 60px; */
	float: right;
	margin-top: 20px;
	width: 270px;
	height: 35px;
	/* box-sizing: border-box; */
	/* 	border: 2px solid #ccc;
 */
	/* background-image: url('${pageContext.request.contextPath}/resources/assets/images/searchicon.png'); */
	/*     border-radius: 4px; */
	font-size: 16px; /* 
    background-color: white;
   background-image: url('${pageContext.request.contextPath}/resources/assets/images/searchicon.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out; */
}
</style>
<div id="page-wrapper" align="left">


	<!-------------------------------------------------------Code for Right Menu------------------------------------------------------------------------->
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <hr/>
			  <table>
			  <tr><td><span>&nbsp; &nbsp;<i class="fa fa-home" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/dashboard">Home</a></span></td></tr>
			  <tr><td><span>&nbsp; &nbsp;<i class="fa fa-gear fa-spin" style="font-size:24px;color:red"></i><a href="${pageContext.request.contextPath}/user/getProfileSettings">Settings</a></span></td></tr>
			   <!-- <tr><td><span>&nbsp; &nbsp;<i class="material-icons" style="font-size:28px;color:red">add_alert</i><a href="#">Notifications</a></span></td></tr> -->
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-diamond" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/rules">Rules</a></span></td></tr>
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-gift" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/prizes">Prize</a></span></td></tr>
			   <tr><td><span>&nbsp; &nbsp;<i class="fa fa-pencil-square-o" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/testimonials">Testimonials</a></span></td></tr>
              <tr><td><span>&nbsp; &nbsp;<i class="fa fa-envelope-o" style="font-size:28px;color:red"></i><a href="#" id="fdbckpopup">feedback</a></span></td></tr>

		<!-- The Modal -->
		<div id="feedbackpopup" class="modal">
			<!-- Modal content -->
			<div class="modal-content-feedbackpopup">
				<div class="modal-header">
					<span class="close">&times;</span>
					<h2>Please Share Your Rewiews</h2>
				</div>
				<br />
				<br />
				<div class="modal-body">
					<textarea name="feedback" rows="5" cols="70"
						placeholder="Please provide a detailed description of your ideas or suggestions."
						required="1" aria-required="true"></textarea>
				</div>
				<br />
				<br />
				<div class="modal-footer" align="right">
					<button class="button_submit  submit">Send</button>
					<button class="button_submit  submit">Cancel</button>
				</div>
			</div>
		</div>
		
		<tr><td><span>&nbsp; &nbsp;<i class="fa fa-info-circle" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/aboutUs">About_Us</a></span></tr></td>
        <tr><td><span>&nbsp; &nbsp;<i class="fa fa-phone" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/contactus">Contact_us</a></span></tr></td>
        <tr><td><span>&nbsp; &nbsp;<i class="fa fa-key" style="font-size:28px;color:red"><a href="${pageContext.request.contextPath}/user/changePassword">Change Password</a></span></tr></td>
		<tr><td><span>&nbsp; &nbsp;<i class="fa fa-question-circle" style="font-size:28px;color:red"></i><a href="${pageContext.request.contextPath}/user/quickHelp">Quick Help</a></span></td></tr>
		
	  </table>
	</div>




	<!-- PAGE HEADER BLOCK -->
	<div id="page-header" class="bg-gradient-9" style="padding-left: 10px;">
		<!-----------------------------------------------Code for left navigator menu---------------------------------------------------------------- -->
		<div class="row">
			<div class="col-md-3">
				<span style="font-size: 25px; float: left; cursor: pointer; padding-top: 20; color: #fff; font-style: bold; font-family: Charcoal;" onclick="openNav()">&#9776; Open</span>
			</div>
			<div class="col-md-5 row">


				<form id="search" method="post" action="${pageContext.request.contextPath}/user/search">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<div class="col-md-10" style="padding-right: 0px;">
						<p align="right">
							<input type="text" name="search" class="fa fa-search searchBox" placeholder="&nbsp; Search Your Loved One...." style="color:black;">
						</p>
					</div>

					<div class="col-md-2" style="padding-left: 5px;">
						<p align="left">
							<button class="btn btn-default" style="border-radius: 0;" type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</p>
					</div>
				</form>

			</div>
			<div class="col-md-4">
				<a id="logout-btn" href="${pageContext.request.contextPath}/logout" title="Logout">
					<img class="mrg_none" width="30" align="right" src="${pageContext.request.contextPath}/resources/assets/images/logoutbtn.png" style="margin: 18px !important" alt="Profile image">
				</a>

			</div>

		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/view/home.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.css"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
</div>
