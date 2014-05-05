'use strict';

francosApp
    .config(['$routeProvider', '$httpProvider', '$translateProvider',
        function ($routeProvider, $httpProvider, $translateProvider) {
            $routeProvider
                .when('/guestorder', {
                    templateUrl: 'views/guestorders.html',
                    controller: 'GuestOrderController',
                    resolve:{
                        resolvedGuestOrder: ['GuestOrder', function (GuestOrder) {
                            return GuestOrder.query();
                        }]
                    }
                })
        }]);
