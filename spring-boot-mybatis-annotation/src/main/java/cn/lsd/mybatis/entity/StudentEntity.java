package cn.lsd.mybatis.entity;

import java.io.Serializable;

/**
 * @Author: LSD
 * @Date: 2018/9/14
 */
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 6419996304609294674L;

    private Integer id;

    private String name;

    private String gender;

    private ClassEntity clazz;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ClassEntity getClazz() {
        return clazz;
    }

    public void setClazz(ClassEntity clazz) {
        this.clazz = clazz;
    }
}
