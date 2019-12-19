var app = angular.module("carGarage", []);

app.controller('carController', function($http, $scope) {
    $scope.cars = [];
    $scope.mode = "Create"; // Create or Edit
    $scope.msg = "";
    $scope.carForm = {
        model: "",
        color: ""
    };

    _refreshData();

    $scope.addCar = function () {
        _clearForm();

        $scope.mode = "Create";
        $scope.msg = "";
    };

    $scope.submitCar = function () {
        var method = 'POST';
        var url = '/car';
        var carFormForSubmit = { // without id
            model: $scope.carForm.model,
            color: $scope.carForm.color
        };

        if ($scope.carForm.hasOwnProperty('id')) { // means editing
            method = 'PUT';
            url = '/car/' + $scope.carForm.id;
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson(carFormForSubmit),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.updateCar = function (car) {
        $scope.carForm = {
            id: car.id,
            model: car.model,
            color: car.color
        };

        $scope.mode = "Edit";
        $scope.msg = "";
    };

    $scope.deleteCar = function (car) {
        $http({
            method: 'DELETE',
            url: '/car/' + car.id
        }).then(_success, _error);

        if ($scope.mode == "Edit" && $scope.carForm.id == car.id) $scope.msg = "Error! This car was deleted.";
    };

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
        delete $scope.carForm.id;
        $scope.carForm.model = "";
        $scope.carForm.color = "";
    }

    function _success(result) {
        _refreshData();
    }

    function _error(result) {
        console.log("Error: " + result.status + " : " + result.data);
    }
});