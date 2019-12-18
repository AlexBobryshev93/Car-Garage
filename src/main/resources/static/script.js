var app = angular.module("carGarage", []);

app.controller('carController', function($http, $scope) {
    $scope.cars = [];
    $scope.carForm = {
        model: "",
        color: ""
    };

    _refreshData();

    function _refreshData() {
        $http({
            method: 'GET',
            url: '/cars'
        }).then(
            function(result) { // success
                $scope.cars = result.data;
            },
            function(result) { // error
                console.log("Error: " + result.status + " : " + result.data);
            }
        );
    }

    function _clearForm() {
        $scope.carForm = {
            model: "",
            color: ""
        };
    }

    function _success(result) {
        _refreshData();
        _clearForm();
    }

    function _error(result) {
        console.log("Error: " + result.status + " : " + result.data);
    }
});