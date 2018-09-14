package cn.lsd.angular.service.impl;

import cn.lsd.angular.entity.EmployeeEntity;
import cn.lsd.angular.repository.EmpRepository;
import cn.lsd.angular.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LSD
 * @Date: 2018/9/13
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmpRepository empRepository;

    @Override
    public EmployeeEntity findOne(Integer empId) {
        return empRepository.findOne(empId);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return empRepository.findAll();
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return empRepository.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> findByGender(String gender) {
        return empRepository.findByGender(gender);
    }

    @Override
    public void deleteByEmpId(Integer empId) {
        empRepository.delete(empId);
    }

}
