package cn.lsd.mybatis;

import cn.lsd.mybatis.entity.ClassEntity;
import cn.lsd.mybatis.entity.StudentEntity;
import cn.lsd.mybatis.mapper.ClassMapper;
import cn.lsd.mybatis.mapper.StudentMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LSD
 * @Date: 2018/9/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private StudentMapper studentMapper;


    @Test
    public void findAllClasses() {
        List<ClassEntity> all = classMapper.getAll();
        for (ClassEntity clazz : all) {
            logger.info("classId={}, className={}", clazz.getId(), clazz.getName());
            logger.info("before get student.");
            List<StudentEntity> students = clazz.getStudents();
            for (StudentEntity student : students) {
                logger.info("studentId={}, studentName={}", student.getId(), student.getName());
            }
            logger.info("==================================");
        }
    }

    @Test
    public void findAllStudents() {
        List<StudentEntity> students = studentMapper.getAll();
        for (StudentEntity student : students) {
            logger.info("studentId={}, studentName={}", student.getId(), student.getName());
        }
    }


    @Test
    @Transactional
    public void insertClass() {
        String name = "For Test";
        ClassEntity clazz = new ClassEntity();
        clazz.setName(name);
        classMapper.insert(clazz);
        ClassEntity newClass = classMapper.getById(clazz.getId());
        Assert.assertEquals(name, newClass.getName());
    }

    @Test
    @Transactional
    public void updateClass() {
        String name = "For Test";
        Integer classId = 6;
        ClassEntity clazz = new ClassEntity();
        clazz.setId(classId);
        clazz.setName(name);
        classMapper.updateById(clazz);
        ClassEntity newClass = classMapper.getById(classId);
        Assert.assertEquals(newClass.getName(), name);
    }

    @Test
    public void deleteClass() {
        String name = "For Test";
        ClassEntity clazz = new ClassEntity();
        classMapper.insert(clazz);
        Integer classId = clazz.getId();
        classMapper.deleteById(classId);
        ClassEntity deletedClass = classMapper.getById(classId);
        Assert.assertNull(deletedClass);
    }

    @Test
    @Transactional
    public void insertStudent() {
        String name = "For Test";
        Integer classId = 4;
        StudentEntity student = new StudentEntity();
        ClassEntity clazz = new ClassEntity();
        student.setName(name);
        clazz.setId(classId);
        student.setClazz(clazz);
//		student.setClassId(ClassEntityId);
        studentMapper.insert(student);
        StudentEntity newStudent = studentMapper.getById(student.getId());

        Assert.assertEquals(name, newStudent.getName());
        Assert.assertEquals(classId, newStudent.getClazz().getId());
    }

    @Test
    @Transactional
    public void updateStudent() {
        String name = "For Test";
        Integer classId = 4;
        Integer studentId = 4;
        StudentEntity student = new StudentEntity();
        ClassEntity clazz = new ClassEntity();
        student.setName(name);
        student.setId(studentId);
        clazz.setId(classId);
        student.setClazz(clazz);
        studentMapper.updateById(student);
        StudentEntity newStudent = studentMapper.getById(student.getId());

        Assert.assertEquals(name, newStudent.getName());
        Assert.assertEquals(classId, newStudent.getClazz().getId());
    }

    @Test
    @Transactional
    public void deleteStudent() {
        String name = "For Test";
        Integer classId = 4;
        StudentEntity student = new StudentEntity();
        ClassEntity clazz = new ClassEntity();
        student.setName(name);
        clazz.setId(classId);
        student.setClazz(clazz);
        studentMapper.insert(student);
        Integer studentId = student.getId();
        studentMapper.deleteById(studentId);
        StudentEntity deletedStudent = studentMapper.getById(studentId);
        Assert.assertNull(deletedStudent);
    }

}
