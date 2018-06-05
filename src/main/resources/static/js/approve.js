app.controller('approveController', function($scope, $http,$rootScope) {
    $scope.approve = function(place){
        var config = {
            headers : {
                'Content-Type': 'application/json'
            }
        };
        $http.post('/place/approve?access_token='+localStorage.getItem("token"), place, config).then(
            function(response){
                console.log(response.data)
                $scope.places.splice($scope.places.indexOf(place), 1);
                //window.location.href = "/place.html?id="+response.data.id;
            },
            function(response){
                // failure callback
            }
        );
    }
    $scope.delete = function(place){
        var config = {
            headers : {
                'Content-Type': 'application/json'
            }
        };
        $http.post('/place/delete?access_token='+localStorage.getItem("token"), place, config).then(
            function(response){
                console.log(response.data)

                $scope.places.splice($scope.places.indexOf(place), 1);

                //window.location.href = "/place.html?id="+response.data.id;
            },
            function(response){
                // failure callback
            }
        );
    }
    $http.get("/place/unapproved").then(function (response) {
        $scope.places = response.data;
    });
    $http.get("/place/all").then(function (response) {
        $scope.allPlaces = response.data;
    });
});