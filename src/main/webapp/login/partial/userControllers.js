angular.module('easycoiffure.userControllers',[])
.controller('userCreateController',function ($scope,$state,$stateParams,User) {


    console.log("create user");

    $scope.user = new User();

    $scope.addUser = function(){
        $scope.user.$save(function () {

            $state.go('users')

        });
    }

})