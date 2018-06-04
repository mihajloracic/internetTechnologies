app.controller('placeController', function($scope, $http, $rootScope) {
    $scope.name = "mihajlo";
    $scope.poll = {};
    $scope.poll.places = [];
    $scope.poll.users = [];
    $scope.poll.description = "sent from front end";
    $scope.addPlaces = function(place){
        $scope.poll.places.push(place);
        var index = $scope.places.indexOf(place);
        $scope.places.splice(index, 1);
    }
    $scope.removePlace = function(place){
        $scope.places.push(place);
        var index = $scope.poll.places.indexOf(place);
        $scope.poll.places.splice(index, 1);
    }
    $scope.addUsers = function(user){
        $scope.poll.users.push(user);
        var index = $scope.users.indexOf(user);
        $scope.users.splice(index, 1);
    }
    $scope.removeUser = function(user){
        $scope.users.push(user);
        var index = $scope.poll.users.indexOf(user);
        $scope.poll.users.splice(index, 1);
    }
    $http.get("/place/all").then(function (response) {
        $scope.places = response.data;
    });
    $http.get("/user").then(function (response) {
        $scope.users = response.data;
    });
    $scope.submitForm = function(){
        data = $scope.poll;
        var config = {
            headers : {
                'Content-Type': 'application/json'
            }
        };
        $http.post('/pole?access_token='+localStorage.getItem("token"), data, config).then(
            function(response){
                console.log(response.data)
                //window.location.href = "/place.html?id="+response.data.id;
            },
            function(response){
                // failure callback
            }
        );
    }
});