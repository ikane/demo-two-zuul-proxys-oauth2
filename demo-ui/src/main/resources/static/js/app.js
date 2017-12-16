    

        var app = angular.module("app", ['ngRoute', 'ui.bootstrap']);

        app.config(function ($routeProvider) {
            /*
        	$routeProvider
            .when("/home", { templateUrl: "home.html" })
            .when("/mountain", { templateUrl: "mountain.html", controller: "ListCtrl" })
            .when("/smart_table", { templateUrl: "smart_table.html", controller: "ListCtrl" })
            .when("/carousel", { templateUrl: "carousel.html" })
            .when("/mountain/:id", { templateUrl: "details.html", controller: "DetailsCtrl" })
            .otherwise({ redirectTo: "/home" });
            */
        });

        app.controller("defaultCtrl", function ($scope, $location, $http) {
        	/*
        	$http.get("hello2").then(function(response) {
        		$scope.data = response.data;
        	});
        	*/
        });
