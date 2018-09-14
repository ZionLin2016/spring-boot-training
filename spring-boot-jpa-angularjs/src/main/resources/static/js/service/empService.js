'use strict';
//自定义服务
App.factory('EmpService', ['$http', '$q', function ($http, $q) {

    return {

        fetchAllEmps: function () {
            return $http.get('/emp/list')
                .then(
                    function (response) {
                        return response.data.data;
                    },
                    function (errResponse) {
                        return $q.reject(errResponse);
                    }
                );
        },

        createEmp: function (emp) {
            return $http.post('/emp/save', emp)
                .then(
                    function (response) {
                        return response.data.data;
                    },
                    function (errResponse) {
                        return $q.reject(errResponse);
                    }
                );
        },

        updateEmp: function (emp) {
            return $http.post('/emp/save', emp)
                .then(
                    function (response) {
                        return response.data.data;
                    },
                    function (errResponse) {
                        return $q.reject(errResponse);
                    }
                );
        },

        deleteEmp: function (empId) {
            return $http.delete('/emp/del/' + empId)
                .then(
                    function (response) {
                        return response.data.msg;
                    },
                    function (errResponse) {
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}]);
