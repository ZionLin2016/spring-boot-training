package cn.lsd.angular.repository;

import cn.lsd.angular.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: LSD
 * @Date: 2018/9/13
 */
public interface EmpRepository extends JpaRepository<EmployeeEntity,Integer> {
    //根据性别查找
    List<EmployeeEntity> findByGender(String gender);
}
