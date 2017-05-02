function getService() {

	return "http://localhost:8080/";
}
angular.module('myApp.servers', [])

.service('UserRegistrationSrvc',function ($http,$rootScope) {
	return {

		getRulesDetailsList: function () {
		            $rootScope.loader = true;
		            return $http.get(getService() + "rules/listrules").then(function (resp) {
		                $rootScope.loader = false;
		                return resp.data;
		            }, function (err) {
		                $rootScope.loader = false;
		                alert(err);
		            });
		        },

		save: function (userRegistration) {
			alert("bye1");
			return $http.post(getService() + "registration/save",userRegistration).then(function (response){
				alert("bye2");
				userRegistration=null;
				return response.data;
			}, function (err) {
				userRegistration=null;
				return err;
			});
		}

	}


});

