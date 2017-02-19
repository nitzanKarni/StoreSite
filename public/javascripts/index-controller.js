var app = angular.module('mainApp',['ngMaterial']);

app.controller('index',['$scope', '$http', function($scope, $http) {
    
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
}]);