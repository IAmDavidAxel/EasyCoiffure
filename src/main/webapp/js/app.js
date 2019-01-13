angular
        .module(
            'easycoiffure',
            ['ui.router','ngResource','ngCookies','easycoiffure.barber','easycoiffure.afrocareController','userController',"easycoiffure.afrocareController"]);


angular.module('easycoiffure').config(function($stateProvider, $httpProvider) {

   $stateProvider

       .state('/',{
           templateUrl:'index.html',
           controller : 'homeController'

       })

       .state('/afrocare',{
           url:'/afrocare',
           templateUrl : '/afroCare/partials/afroCare.html',
           controller: 'afrocareController'
       });

    $httpProvider.interceptors.push('APIInterceptor');

}).run(function ($state) {
    $state.go('/');
});
