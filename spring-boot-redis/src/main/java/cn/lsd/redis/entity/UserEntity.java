package cn.lsd.redis.entity;

import javax.persistence.*;

/**
 * @Author: LSD
 * @Date: 2018/9/17
 */
@Entity
@Table(name = "USER")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "NAME", length = 64, nullable = false)
    private String username;

    @Column(name = "EMAIL", length = 64, nullable = false)
    private String email;

    public UserEntity() {
    }

    public UserEntity(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
