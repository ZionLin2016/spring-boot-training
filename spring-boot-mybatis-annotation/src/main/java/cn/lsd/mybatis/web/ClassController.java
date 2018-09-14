package cn.lsd.mybatis.web;

import cn.lsd.mybatis.entity.ClassEntity;
import cn.lsd.mybatis.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: LSD
 * @Date: 2018/9/14
 */
public class ClassController {

    @Autowired
    private ClassMapper classMapper;

    @RequestMapping("/getClasses")
    public List<ClassEntity> getStudents() {
        return classMapper.getAll();
    }

    @RequestMapping("/getClass")
    public ClassEntity getStudent(Integer id) {
        return classMapper.getById(id);
    }

    @RequestMapping("/add")
    public void save(ClassEntity clazz) {
        classMapper.insert(clazz);
    }

    @RequestMapping(value = "update")
    public void update(ClassEntity clazz) {
        classMapper.updateById(clazz);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        classMapper.deleteById(id);
    }
}
