var app = angular.module('myApp', []);
app.run(function($rootScope,$http) {
    $http.get("/user/get?access_token="+localStorage.getItem("token")).then(function (response) {
        $rootScope.user = response.data
        $rootScope.loggedIn = localStorage.getItem("logedIn")
        console.log($rootScope.user);
    });
});
app.controller('navbarcontroller', function($scope, $http,$rootScope) {

});