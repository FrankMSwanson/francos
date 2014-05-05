'use strict';

francosApp.controller('MenuController', ['$scope', 'resolvedMenu', 'Menu',
    function ($scope, resolvedMenu, Menu) {

        $scope.menus = resolvedMenu;

        $scope.create = function () {
            Menu.save($scope.menu,
                function () {
                    $scope.menus = Menu.query();
                    $('#saveMenuModal').modal('hide');
                    $scope.clear();
                });
        };

        $scope.update = function (id) {
            $scope.menu = Menu.get({id: id});
            $('#saveMenuModal').modal('show');
        };

        $scope.delete = function (id) {
            Menu.delete({id: id},
                function () {
                    $scope.menus = Menu.query();
                });
        };

        $scope.clear = function () {
            $scope.menu = {id: "", sampleTextAttribute: "", sampleDateAttribute: ""};
        };
    }]);
