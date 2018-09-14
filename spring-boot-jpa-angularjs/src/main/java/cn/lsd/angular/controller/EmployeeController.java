package cn.lsd.angular.controller;

import cn.lsd.angular.entity.EmployeeEntity;
import cn.lsd.angular.model.ResultModel;
import cn.lsd.angular.service.EmployeeService;
import cn.lsd.angular.utils.ResultModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: LSD
 * @Date: 2018/9/13
 */
@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("home");
    }

    @GetMapping("emp/list")
    public ResultModel<List<EmployeeEntity>> list() {
        List<EmployeeEntity> employeeEntityList = employeeService.findAll();
        return ResultModelUtil.success(employeeEntityList);
    }

    @GetMapping(value = "emp/{id}")
    public ResultModel<EmployeeEntity> getEmployee(@PathVariable("id") Integer id) {
        EmployeeEntity employeeEntity = employeeService.findOne(id);
        if (employeeEntity == null) {
            return ResultModelUtil.error(400, "未找到相关记录");
        }
        return ResultModelUtil.success(employeeEntity);
    }

    @PostMapping("emp/save")
    public ResultModel<EmployeeEntity> save(@RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity result = employeeService.save(employeeEntity);
        return ResultModelUtil.success(result);
    }

    @DeleteMapping("emp/del/{empId}")
    public ResultModel delEmp(@PathVariable("empId") Integer empId) {
        employeeService.deleteByEmpId(empId);
        return ResultModelUtil.success();
    }


}
