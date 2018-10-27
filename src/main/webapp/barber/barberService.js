angular.module('easyCoiffureApp.barberServices',[]).factory('Barber',function ($resource) {
    return $resource('http://localhost:8080/api/barber/')
    ,{
        save:{
            method: 'POST'
        }
    }
});