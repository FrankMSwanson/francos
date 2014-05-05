'use strict';

francosApp.factory('GuestOrder', ['$resource',
    function ($resource) {
        return $resource('app/rest/guestorders/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': { method: 'GET'}
        });
    }]);
