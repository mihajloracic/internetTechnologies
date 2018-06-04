var app = angular.module('myApp', []);
app.run(function($rootScope,$http) {
    $rootScope.loggedIn = false;
    $http.get("/user/get?access_token="+localStorage.getItem("token")).then(function (response) {
        $rootScope.user = response.data
        $rootScope.loggedIn = true;
    });
});
app.controller('navbarcontroller', function($scope, $http,$rootScope) {
    $scope.logout = function(){
        $rootScope.loggedIn = false;
        $rootScope.user = '';
        localStorage.setItem("token",'')
    }
});