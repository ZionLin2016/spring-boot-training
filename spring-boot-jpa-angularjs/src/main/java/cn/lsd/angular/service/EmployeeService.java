package cn.lsd.angular.service;



import cn.lsd.angular.entity.EmployeeEntity;

import java.util.List;

/**
 * @Author: LSD
 * @Date: 2018/9/13
 */
public interface EmployeeService {

    EmployeeEntity findOne(Integer empId);

    List<EmployeeEntity> findAll();

    EmployeeEntity save(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findByGender(String gender);

    void deleteByEmpId(Integer empId);


}
