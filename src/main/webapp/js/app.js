angular
        .module(
            'easycoiffure',
            ['ui.router','ngResource','ngCookies','easycoiffure.barber','homeController','userController'])


.run(function ($rootScope,$resource,) {

});

angular.module('easycoiffure').config(function($stateProvider, $httpProvider,$routeProvider) {

$routeProvider.when('/',{
    templateUrl : 'home/home.html',
    controller : 'homeController'
})
    $stateProvider.state('home',{
        url :"/",
        templateUrl :'home/partials/home.html',
        controller:'homeController'
    }).state('barber', {
        url: '/barber',
        templateUrl: 'barber/',
        controller: 'BarberCreateController'
    });

    $httpProvider.interceptors.push('APIInterceptor');

}).run(function ($state) {
    $state.go('home');
});
