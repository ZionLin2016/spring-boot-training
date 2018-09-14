package cn.lsd.angular.repository;

import cn.lsd.angular.entity.EmployeeBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Zoin
 * @Date: 2018/9/13
 */
public interface EmpRepository extends JpaRepository<EmployeeBean,Integer> {
    //根据性别查找
    List<EmployeeBean> findByGender(String gender);
}
