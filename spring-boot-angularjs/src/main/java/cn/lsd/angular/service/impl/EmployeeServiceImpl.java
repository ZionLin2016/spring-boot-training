package cn.lsd.angular.service.impl;

import cn.lsd.angular.entity.EmployeeBean;
import cn.lsd.angular.repository.EmpRepository;
import cn.lsd.angular.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Zoin
 * @Date: 2018/9/13
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmpRepository empRepository;

    @Override
    public EmployeeBean findOne(Integer empId) {
        return empRepository.findOne(empId);
    }

    @Override
    public List<EmployeeBean> findAll() {
        return empRepository.findAll();
    }

    @Override
    public EmployeeBean save(EmployeeBean employeeBean) {
        return empRepository.save(employeeBean);
    }

    @Override
    public List<EmployeeBean> findByGender(String gender) {
        return empRepository.findByGender(gender);
    }

    @Override
    public void deleteByEmpId(Integer empId) {
        empRepository.delete(empId);
    }

}
