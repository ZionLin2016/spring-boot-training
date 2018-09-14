package cn.lsd.mybatis.mapper;

import cn.lsd.mybatis.entity.ClassEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

import static org.apache.ibatis.mapping.FetchType.LAZY;

/**
 * @Author: LSD
 * @Date: 2018/9/14
 */
@Mapper
public interface ClassMapper {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "code", property = "code"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "students", many = @Many(select = "cn.lsd.mybatis.mapper.StudentMapper.getByClassId", fetchType = LAZY))
    })
    @Select("select * from class")
    List<ClassEntity> getAll();

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "code", property = "code"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "students", many = @Many(select = "cn.lsd.mybatis.mapper.StudentMapper.getByClassId", fetchType = LAZY))
    })
    @Select("select * from class where class_id = #{id}")
    ClassEntity getById(Integer id);

    @Insert("INSERT INTO class(code,name) VALUES(#{code}, #{name})")
    Integer insert(ClassEntity clazz);

    @Update("UPDATE class SET name=#{name},code=#{code} WHERE class_id =#{id}")
    Integer updateById(ClassEntity clazz);

    @Delete("delete from class where class_id = #{id}")
    Integer deleteById(Integer id);

}
