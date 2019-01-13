angular
        .module('easycoiffure.afrocareService',[]).factory('afrocare',function ($resource) {

            return $resource('http://localhost:8080/afrocare/partials/afrocare.html')
})