'use strict';

francosApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/menu', {
                    templateUrl: 'views/menus.html',
                    controller: 'MenuController',
                    resolve:{
                        resolvedMenu: ['Menu', function (Menu) {
                            return Menu.query();
                        }]
                    }
                })
        }]);
