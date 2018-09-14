package cn.lsd.angular.service.impl;

import cn.lsd.angular.entity.EmployeeBean;
import cn.lsd.angular.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: Zoin
 * @Date: 2018/9/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeBeanServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void findOne() throws Exception {
        EmployeeBean employeeBean = employeeService.findOne(1);
        Assert.assertNotEquals(new Integer(0), employeeBean.getEmpId());
    }

    @Test
    public void findAll() throws Exception {
        List<EmployeeBean> employeeBeanList = employeeService.findAll();
        Assert.assertNotEquals(0, employeeBeanList.size());
    }

    @Test
    public void save() throws Exception {

        EmployeeBean employeeBean = new EmployeeBean();
        employeeBean.setEmpName("李四");
        employeeBean.setdId(1);
        employeeBean.setEmail("124554@qq.com");
        employeeBean.setGender("男");
        EmployeeBean result = employeeService.save(employeeBean);
        Assert.assertNotEquals(new Integer(0),result.getdId());

    }

    @Test
    public void findByGender() throws Exception {
        List<EmployeeBean> employeeBeanList = employeeService.findByGender("男");
        Assert.assertNotEquals(0, employeeBeanList.size());
    }

    @Test
    public void deleteEmployee() throws Exception {
        employeeService.deleteByEmpId(1);
    }

}