package cn.lsd.mybatis.mapper;

import cn.lsd.mybatis.entity.StudentEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.apache.ibatis.mapping.FetchType.LAZY;

/**
 * @Author: LSD
 * @Date: 2018/9/14
 */
@Mapper
public interface StudentMapper {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "class_id", property = "clazz", one = @One(select = "cn.lsd.mybatis.mapper.ClassMapper.getById", fetchType = LAZY)),
    })
    @Select("select * from student")
    List<StudentEntity> getAll();

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "class_id", property = "clazz", one = @One(select = "cn.lsd.mybatis.mapper.ClassMapper.getById", fetchType = LAZY)),
    })
    @Select("select * from student where stu_id = #{id}")
    StudentEntity getById(Integer id);

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "class_id", property = "clazz", one = @One(select = "cn.lsd.mybatis.mapper.ClassMapper.getById", fetchType = LAZY)),
    })
    @Select("select * from student where class_id = #{classId}")
    List<StudentEntity> getByClassId(Integer classId);

    @Insert("INSERT INTO student(name,gender) VALUES(#{name}, #{gender})")
    Integer insert(StudentEntity student);

    @Update("UPDATE student SET name=#{name},gender=#{gender} WHERE stu_id =#{id}")
    Integer updateById(StudentEntity student);

    @Delete("delete from student where stu_id = #{id}")
    Integer deleteById(Integer id);
}
