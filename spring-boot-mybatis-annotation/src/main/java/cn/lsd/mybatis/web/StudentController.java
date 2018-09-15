package cn.lsd.mybatis.web;

import java.util.List;

import cn.lsd.mybatis.entity.StudentEntity;
import cn.lsd.mybatis.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LSD
 * @Date: 2018/9/14
 */
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/getStudents")
    public List<StudentEntity> getStudents() {
        return studentMapper.getAll();
    }

    @RequestMapping("/getStudent")
    public StudentEntity getStudent(Integer id) {
        return studentMapper.getById(id);
    }

    @RequestMapping("/getByClassId")
    public List<StudentEntity> getByClassId(Integer id) {
        return studentMapper.getByClassId(id);
    }

    @RequestMapping("/add")
    public void save(StudentEntity stu) {
        studentMapper.insert(stu);
    }

    @RequestMapping(value = "update")
    public void update(StudentEntity user) {
        studentMapper.updateById(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        studentMapper.deleteById(id);
    }
}