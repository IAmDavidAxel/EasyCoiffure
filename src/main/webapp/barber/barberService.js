angular.module('easycoiffure.barberServices',[]).factory('Barber',function ($resource) {
    return $resource('/api/barber/')
    ,{
        save:{
            method: 'POST'
        }
    }
});