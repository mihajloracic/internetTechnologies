app.controller('postController', function($scope, $http,$rootScope) {
    $scope.place = {};
    $scope.submitForm = function(){
        $scope.place.userCreated = $rootScope.user
        data = $scope.place;
        var config = {
            headers : {
                'Content-Type': 'application/json'
            }
        };
        $http.post('/place/admin/add_place?access_token='+localStorage.getItem("token"), data, config).then(
            function(response){
                console.log(response.data)
                window.location.href = "/place.html?id="+response.data.id;
            },
            function(response){
                // failure callback
            }
        );
    }
});