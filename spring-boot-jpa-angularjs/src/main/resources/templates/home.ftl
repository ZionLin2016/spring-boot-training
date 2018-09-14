<html>

<head>
    <title>SpringBoot-angualar实例</title>

    <link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
    <script type='text/javascript' src="webjars/jquery/2.2.4/jquery.min.js"></script>
    <script type='text/javascript' src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/angularjs/1.5.0/angular.min.js"></script>
    <script type="text/javascript" src="webjars/angularjs/1.5.0/angular-route.min.js"></script>
    <script type="text/javascript" src="../js/app.js"></script>
    <script type="text/javascript" src="../js/service/empService.js"></script>
    <script type="text/javascript" src="../js/controller/empController.js"></script>
</head>

<body ng-app="myApp" class="ng-cloak">
<div class="form-group" ng-controller="EmpController as ctrl">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <span class="lead">SpringBoot整合AngularJS</span>
        </div>
        <div class="panel-body">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.emp.empId" />
                <div class="row">
                    <div class="form-group col-md-8">
                        <label class="col-md-2" for="file">empName</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="ctrl.emp.empName" name="empName" class="form-control" placeholder="Enter your name" required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-8">
                        <label class="col-md-2" for="file">gender</label>
                        <div class="col-md-6">
                            <input type="text" ng-model="ctrl.emp.gender" name="gender" class="form-control" placeholder="Enter your Gender" required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-8">
                        <label class="col-md-2" for="file">email</label>
                        <div class="col-md-6">
                            <input type="email" ng-model="ctrl.emp.email" name="email" class="form-control" placeholder="Enter your Email" required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-8">
                        <input type="submit" value="{{!ctrl.emp.empId ? '添加' : '修改'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <span class="lead">员工列表</span>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>empId</th>
                    <th>empName</th>
                    <th>gender</th>
                    <th>email</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="e in ctrl.emps">
                    <td><span ng-bind="e.empId"></span></td>
                    <td><span ng-bind="e.empName"></span></td>
                    <td><span ng-bind="e.gender"></span></td>
                    <td><span ng-bind="e.email"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(e.empId)" class="btn btn-success btn-xs">修改</button>
                        <button type="button" ng-click="ctrl.remove(e.empId)" class="btn btn-danger btn-xs">删除</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

</html>