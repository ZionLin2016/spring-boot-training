package cn.lsd.rabbitmq.model;

import java.io.Serializable;

/**
 * @Author: LSD
 * @Date: 2018/9/15
 */
public class UserModel implements Serializable{

    private static final long serialVersionUID = 2096904794177912501L;

    private String name;

    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
