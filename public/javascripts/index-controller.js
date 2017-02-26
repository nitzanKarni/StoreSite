var app = angular.module('mainApp',['ngMaterial','ngRoute']);

app.controller('index',['$scope', '$http', function($scope, $http, $location) {
    
    // Simple GET request example:
   $http({
       method: 'GET',
       url: '/127.0.0.1:9000/products'
   }).then(function successCallback(response) {
       $scope.products = JSON.parse(response.data);
   }, function errorCallback(response) {
       // called asynchronously if an error occurs
       // or server returns response with an error status.
   });
    
    $scope.imagePath = 'images/530x500_back_1.jpg';
    $scope.title1 = 'Good morning';


    $scope.selectedIndex = 0;

        $scope.$watch('selectedIndex', function(current, old) {
            switch (current) {
                case 0:
                    $location.url("/view1");
                    break;
                case 1:
                    $location.url("/view2");
                    break;
            }
        });
}]);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "/views/catalog.html",
        controller : "/javascripts/index-controller.js",
        url: "/view1",
    }).when("/catalog", {
        templateUrl : ""
    }).when("/about", {
        templateUrl : "/views/about.html",
        url: "/view2"
    })
});