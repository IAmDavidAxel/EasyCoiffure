angular.module('easyCoiffureApp.barberControllers',[])
.controller('BarberListController', function ($scope, $state , $window, Barber) {

    $scope.barbers = Barber.query();

}).controller('BarberCreateController', function ($scope, $state,$stateParams,Barber) {

    console.log("createBarber");
    $scope.barber = new Barber();

    $scope.addBarber = function () {
        $scope.barber.$save(function () {
            $state.go('barbers')
        });

    }

})