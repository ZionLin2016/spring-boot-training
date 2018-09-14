package cn.lsd.angular.controller;

import cn.lsd.angular.entity.EmployeeBean;
import cn.lsd.angular.model.ResultModel;
import cn.lsd.angular.service.EmployeeService;
import cn.lsd.angular.utils.ResultModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Zoin
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
    public ResultModel<List<EmployeeBean>> list() {
        List<EmployeeBean> employeeBeanList = employeeService.findAll();
        return ResultModelUtil.success(employeeBeanList);
    }

    @GetMapping(value = "emp/{id}")
    public ResultModel<EmployeeBean> getEmployee(@PathVariable("id") Integer id) {
        EmployeeBean employeeBean = employeeService.findOne(id);
        if (employeeBean == null) {
            return ResultModelUtil.error(400, "未找到相关记录");
        }
        return ResultModelUtil.success(employeeBean);
    }

    @PostMapping("emp/save")
    public ResultModel<EmployeeBean> save(@RequestBody EmployeeBean employeeBean) {
        EmployeeBean result = employeeService.save(employeeBean);
        return ResultModelUtil.success(result);
    }

    @DeleteMapping("emp/del/{empId}")
    public ResultModel delEmp(@PathVariable("empId") Integer empId) {
        employeeService.deleteByEmpId(empId);
        return ResultModelUtil.success();
    }


}
