app.controller('mypolesController', function($scope, $http, $rootScope) {
    $http.get("/pole").then(function (response) {
        $scope.polles = response.data;
    });
});