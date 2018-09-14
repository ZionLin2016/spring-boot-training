package cn.lsd.angular.service;



import cn.lsd.angular.entity.EmployeeBean;

import java.util.List;

/**
 * @Author: Zoin
 * @Date: 2018/9/13
 */
public interface EmployeeService {

    EmployeeBean findOne(Integer empId);

    List<EmployeeBean> findAll();

    EmployeeBean save(EmployeeBean employeeBean);

    List<EmployeeBean> findByGender(String gender);

    void deleteByEmpId(Integer empId);


}
