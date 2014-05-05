'use strict';

francosApp.controller('GuestOrderController', ['$scope', 'resolvedGuestOrder', 'GuestOrder',
    function ($scope, resolvedGuestOrder, GuestOrder) {

        $scope.guestorders = resolvedGuestOrder;

        $scope.create = function () {
            GuestOrder.save($scope.guestorder,
                function () {
                    $scope.guestorders = GuestOrder.query();
                    $('#saveGuestOrderModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.guestorder = GuestOrder.get({id: id});
            $('#saveGuestOrderModal').modal('show');
        };

        $scope.delete = function (id) {
            GuestOrder.delete({id: id},
                function () {
                    $scope.guestorders = GuestOrder.query();
                });
        };

        $scope.clear = function () {
            $scope.guestorder = {id: "", sampleTextAttribute: "", sampleDateAttribute: ""};
        };
    }]);
