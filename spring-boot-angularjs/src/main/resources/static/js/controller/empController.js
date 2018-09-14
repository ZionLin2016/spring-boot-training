'use strict';

App.controller('EmpController', ['$scope', 'EmpService', function($scope, EmpService) {
    var self = this;
    self.emp={empId:null,empName:'',gender:'',email:''};
    self.emps=[];

    self.fetchAllEmps = function(){
        EmpService.fetchAllEmps()
            .then(
                function(d) {
                    self.emps = d;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies');
                }
            );
    };

    self.createEmp = function(emp){
        EmpService.createEmp(emp)
            .then(
                self.fetchAllEmps,
                function(errResponse){
                    console.error('Error while creating Emp.');
                }
            );
    };

    self.updateEmp = function(emp){
        EmpService.updateEmp(emp)
            .then(
                self.fetchAllEmps,
                function(errResponse){
                    console.error('Error while updating Emp.');
                }
            );
    };

    self.deleteEmp = function(empId){
        EmpService.deleteEmp(empId)
            .then(
                self.fetchAllEmps,
                function(errResponse){
                    console.error('Error while deleting Emp.');
                }
            );
    };

    self.fetchAllEmps();

    self.submit = function() {
        if(self.emp.empId==null){
            self.createEmp(self.emp);
        }else{
            self.updateEmp(self.emp);
        }
        self.reset();
    };

    self.edit = function(id){
        for(var i = 0; i < self.emps.length; i++){
            if(self.emps[i].empId == id) {
                self.emp = angular.copy(self.emps[i]);
                break;
            }
        }
    };

    self.remove = function(id){
        for(var i = 0; i < self.emps.length; i++){
            if(self.emps[i].empId == id) {
                self.reset();
                break;
            }
        }
        self.deleteEmp(id);
    };


    self.reset = function(){
        self.emp={empId:null,empName:'',gender:'',email:''};
        $scope.myForm.$setPristine(); //reset Form $setPristine 回到原始状态
    };

}]);
