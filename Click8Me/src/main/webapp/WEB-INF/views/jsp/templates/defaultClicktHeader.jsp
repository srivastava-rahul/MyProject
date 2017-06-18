<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    margin-right: 60px;
    
    float: right;
    margin-top: 20px;
     width: 270px;
     height : 35px;
    /* box-sizing: border-box; */
    border: 2px solid #ccc;
/* background-image: url('${pageContext.request.contextPath}/resources/assets/images/searchicon.png'); */
/*     border-radius: 4px; */
    font-size: 16px;/* 
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
              <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a><hr>
			  <span>&nbsp; &nbsp;<i class="fa fa-home" style="font-size:28px;color:red"></i><a href="home.html">Home</a><hr></span>
              <span>&nbsp; &nbsp;<i class="fa fa-photo" style="font-size:28px;color:red"></i><a href="#">My Own-pics</a><hr></span>
              <span>&nbsp; &nbsp;<i class="fa fa-gear fa-spin" style="font-size:28px;color:red"></i><a href="#setting">Setting</a><hr></span>
			  <span>&nbsp; &nbsp;<i class="material-icons" style="font-size:28px;color:red"></i><a>Upload Pics</a><hr></span>
              <span>&nbsp; &nbsp;<i class="material-icons" style="font-size:28px;color:red"></i><a href="#">Notification</a><hr></span>
			  <span>&nbsp; &nbsp;<i  class="fa fa-info-circle"  style="font-size:28px;color:red"></i><a href="#">AboutUs</a><hr></span>
			  <span>&nbsp; &nbsp;<i class="fa fa-pencil-square-o" style="font-size:28px;color:red"></i><a>Testimonial</a><hr></span>
              <span>&nbsp; &nbsp;<i class="fa fa-envelope-o" style="font-size:28px;color:red"></i><a href="#" id="fdbckpopup">feedback</a> <hr></span>
											
										<!-- The Modal -->
										<div id="feedbackpopup" class="modal">
												  <!-- Modal content -->
												 <div class="modal-content-feedbackpopup">
													<div class="modal-header">
													  <span class="close">&times;</span>
													  <h2>Please Share Your Rewiews</h2>
													</div>
													<br/><br/>
													<div class="modal-body">
													 <textarea name="details" cols="53" rows="5" placeholder="Please provide a detailed description of your ideas or suggestions." required="1" aria-required="true"></textarea>
													</div>
													<br/><br/>
													<div class="modal-footer" align="right">
													<button class="button_submit  submit" >Send</button>
													 <button class="button_submit  submit" >Cancel</button>
													</div>
												  </div>
												</div>
       <br/><hr>
     <!--  <span>&nbsp; &nbsp;<img src="images/icon-logout.png" width="30px" height="30px"/><a href="#">Log Out</a></span> -->
      </div>
      
      


		<!-- PAGE HEADER BLOCK -->
		<div id="page-header" class="bg-gradient-9" style="padding-left: 10px;">
		<!-----------------------------------------------Code for left navigator menu---------------------------------------------------------------- -->				 
		 <div class="row">
		 <div class="col-md-3">
		 <span style="font-size:25px;float:left;cursor:pointer;padding-top: 20;color: #fff;font-style: bold;font-family: Charcoal;  " onclick="openNav()">&#9776; Open</span>
    		</div>
    		<div class="col-md-5" >
	
		
<form>
<input type="text" name="search" class="fa fa-search searchBox" placeholder="Search..">
<p align="right">
 <button class="btn btn-default" type="submit">
									<span class="glyphicon glyphicon-search"></span>
								</button>
		</p>
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
 </div>
		