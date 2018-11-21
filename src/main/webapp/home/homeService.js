angular.module('easycoiffure').factory('',function ($resource) {

    return $resource

    ('api/easycoiffure/',{

        get:{
            method : 'GET',
            isArray : false
        },
        round : {
            url :'/api/'
        }
    })
})