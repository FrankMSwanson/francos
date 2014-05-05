'use strict';

francosApp.factory('Menu', ['$resource',
    function ($resource) {
        return $resource('app/rest/menus/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': { method: 'GET'}
        });
    }]);
