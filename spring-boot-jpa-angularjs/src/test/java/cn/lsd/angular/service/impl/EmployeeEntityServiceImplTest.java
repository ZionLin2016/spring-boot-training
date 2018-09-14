package cn.lsd.angular.service.impl;

import cn.lsd.angular.entity.EmployeeEntity;
import cn.lsd.angular.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: LSD
 * @Date: 2018/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeEntityServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void findOne() throws Exception {
        EmployeeEntity employeeEntity = employeeService.findOne(1);
        Assert.assertNotEquals(new Integer(0), employeeEntity.getEmpId());
    }

    @Test
    public void findAll() throws Exception {
        List<EmployeeEntity> employeeEntityList = employeeService.findAll();
        Assert.assertNotEquals(0, employeeEntityList.size());
    }

    @Test
    public void save() throws Exception {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpName("李四");
        employeeEntity.setdId(1);
        employeeEntity.setEmail("124554@qq.com");
        employeeEntity.setGender("男");
        EmployeeEntity result = employeeService.save(employeeEntity);
        Assert.assertNotEquals(new Integer(0),result.getdId());

    }

    @Test
    public void findByGender() throws Exception {
        List<EmployeeEntity> employeeEntityList = employeeService.findByGender("男");
        Assert.assertNotEquals(0, employeeEntityList.size());
    }

    @Test
    public void deleteEmployee() throws Exception {
        employeeService.deleteByEmpId(1);
    }

}