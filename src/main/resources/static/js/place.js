app.controller('placeViewController', function($scope,$rootScope, $http) {
    $http.get("/place/byId?id="+getUrlVars()["id"]).then(function (response) {
        $scope.place = response.data;
        $http.post("/rating/get",$scope.place).then(function (response) {
            $scope.rating = response.data
            console.log("rating"+response.data)
        });
    });
    $http.get("/comment?id="+getUrlVars()["id"]).then(function (response) {
        $scope.comments = response.data;
        console.log(response.data)
    });
    $scope.addComment = function(ct){
        var data = {
            userId: $rootScope.user.id,
            placesId: getUrlVars()["id"],
            commentText : ct
        };

        var config = {
            headers : {
                'Content-Type': 'application/json'
            }
        }
        /rating/get
        $http.post('/comment?access_token='+localStorage.getItem("token"), data, config).then(
            function(response){
                console.log(response.data)
                $scope.comments.push(response.data)
                console.log($scope.comments)
            },
            function(response){
                // failure callback
            }
        );
        $http.post('/comment?access_token='+localStorage.getItem("token"), data, config).then(
            function(response){
                console.log(response.data)
                $scope.comments.push(response.data)
                console.log($scope.comments)
            },
            function(response){
                // failure callback
            }
        );

    }
});
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}