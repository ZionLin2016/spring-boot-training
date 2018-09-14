package cn.lsd.mybatis.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: LSD
 * @Date: 2018/9/14
 */
public class ClassEntity implements Serializable {

    private static final long serialVersionUID = 3118371908810122106L;

    private Integer id;

    private String code;

    private String name;

    private List<StudentEntity> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
