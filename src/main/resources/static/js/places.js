app.controller('placeController', function($scope, $http, $rootScope) {
    $http.get("/place/all").then(function (response) {
        $scope.places = response.data;
    });
});