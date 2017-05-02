angular.module('myApp', ['ui.router','myApp.controllers','myApp.servers'])

.config(function($httpProvider,$stateProvider, $urlRouterProvider) {
	/*TitleProvider.enabled(false);*/
	  $stateProvider.state('hello', {
	        url: '/hello',
	        cache: false,
	        controller: 'UserRegistrationCtrl',
	        templateUrl: 'index.html',
	   });
   
 /*  $stateProvider.state('bye', {
       url: '/bye',
       cache: false,
       templateUrl: 'templates/hello.html',
      
   });*/
   
     $stateProvider.state('home', {
    	        url: '/home',
		        cache: false,
		        controller: 'HomePageCtrl',
		        templateUrl: 'templates/home.html',
		        
		   });
     $stateProvider.state('winner', {
	        url: '/winner',
	        cache: false,
	        controller: 'winner',
	        templateUrl: 'templates/Winner.html',
	   });
   
   $urlRouterProvider.otherwise('/hello');
  
});