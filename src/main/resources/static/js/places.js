app.controller('placeController', function($scope, $http) {
    $http.get("/place/all").then(function (response) {
        $scope.places = response.data;
    });
});