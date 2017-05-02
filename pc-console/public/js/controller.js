angular.module('myApp.controllers',[])

/*.controller('UserRegistration', function ($scope,UserRegistrationSrvc,$http,$location,$state, $rootScope){

	alert("hello1");
	UserRegistrationSrvc.moduleDetails().then(function(response) {
    	  alert("hello2");
		 $scope.rahul=response;
		});

})*/



.controller('UserRegistrationCtrl', function ($scope,UserRegistrationSrvc,$http,$location,$state,$rootScope,$timeout){
	
     UserRegistrationSrvc.getRulesDetailsList().then(function (rulesdetailslist) {
		$scope.ruleslslist = rulesdetailslist;
	});


	$scope.buttonvalue="Show-Rules";
	$scope.flage=false;
	$scope.flage1=false;
	$scope.switchbutton=true;

	//--------------code for rule button----------------------------------------- 
	$scope.setvisiblity=function(){
		$scope.flage=!$scope.flage;
		if($scope.flage){
			$scope.buttonvalue="Hide-Rules";
		}else{
			$scope.buttonvalue="Show-Rules";
		}
	}
	//------------------code for Timer-------------------------------------------  
	var myVar = setInterval(myTimer,1000);
	function myTimer() {
		var d = new Date();
		document.getElementById("demo").innerHTML = d.toLocaleTimeString();
	}

	//------------------code for Comment-------------------------------------------  
	
	//--------code for the Singup button diasble----------------------------------
	


	//========================controller to save user=======================================================================================
	$scope.openSignUpForm = function (form) {
		$scope.userRegistration= "";
		$scope.firstname = "";
		$scope.lastName = "";
		$scope.phone = "";
		$scope.email_id = "";
		$scope.password = "";
		$scope.dob = ""; 
		$scope.gender = "";
		$scope.tick = "";  

		if (form) {
			form.$setPristine();
			form.$setUntouched();
		}
	};
	$scope.saveuser=function(userRegistration){
		$scope.errorMessage = null ;
		$scope.message = null;

		if(userRegistration.tick!=null){
			if(userRegistration.gender!=null){
				UserRegistrationSrvc.save(userRegistration).then(function (response) {
					if (response.message == "Sucessfully Registered") {
						$('#SignUpForm').modal('hide');
						$('.modal-backdrop.in').remove();
						userRegistration=null;
						$scope.message = response.message;
					} else {
						$scope.errorMessage = response.message;
						$('#SignUpForm').modal('show');
						/*$scope.userRegistration.$setPristine();*/
					}

				}, function (err) {
					alert("Request Failed.");
				});

			}else{
				$scope.errorMessage ="Select the Gender" ;
				$('#SignUpForm').modal('show');
			}
			
		}
		else{
			$scope.errorMessage = "Please Accept the Terms And conditions" ;
			$('#SignUpForm').modal('show');
		}$timeout(function () {
			$scope.message = "";
			$scope.errorMessage = "" ;
		}, 3000);

	}


	//---------------------------------------Pics popUp code-------------------------------------------
	/*function openModal() {
    	  document.getElementById('myModal').style.display = "block";
    	}

    	function closeModal() {
    	  document.getElementById('myModal').style.display = "none";
    	}

    	var slideIndex = 1;
    	showSlides(slideIndex);

    	function plusSlides(n) {
    	  showSlides(slideIndex += n);
    	}

    	function currentSlide(n) {
    	  showSlides(slideIndex = n);
    	}

    	function showSlides(n) {
    	  var i;
    	  var slides = document.getElementsByClassName("mySlides");
    	  var dots = document.getElementsByClassName("demo");
    	  var captionText = document.getElementById("caption");
    	  if (n > slides.length) {slideIndex = 1}
    	  if (n < 1) {slideIndex = slides.length}
    	  for (i = 0; i < slides.length; i++) {
    	      slides[i].style.display = "none";
    	  }
    	  for (i = 0; i < dots.length; i++) {
    	      dots[i].className = dots[i].className.replace(" active", "");
    	  }
    	  slides[slideIndex-1].style.display = "block";
    	  dots[slideIndex-1].className += " active";
    	  captionText.innerHTML = dots[slideIndex-1].alt;

    	}*/
	/*$scope.saveCommand = function () {
				UserRegistrationSrvc.moduleDetails().then(function(response) {
			    	  alert("hello2");
					 $scope.rahul=response;
					});
		    } */


}) 

.controller('HomePageCtrl', function ($scope,HomePageSrv,$http,$location,$state,$rootScope,$timeout){
	
	alert("hello");
	
	
	$scope.openfeedbackForm = function (form) {
		alert("hello");
		$scope.feedbackmessage= "";
		$scope.errorMessage="";
		$scope.message = "";
		 if (form) {
			form.$setPristine();
			form.$setUntouched();
		}
	};
	
	
});	
