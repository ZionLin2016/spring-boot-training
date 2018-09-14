package cn.lsd.angular.entity;


import javax.persistence.*;

/**
 * @Author: Zoin
 * @Date: 2018/9/13
 */
@Entity
@Table(name = "EMP")
public class EmployeeBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID", nullable = false, updatable = false)
    private Integer empId;

    @Column(name = "NAME", length = 64, nullable = false)
    private String empName;

    @Column(name = "GENDER", length = 16, nullable = false)
    private String gender;

    @Column(name = "EMAIL", length = 64, nullable = false)
    private String email;

    @Column(name = "DID", length = 64, nullable = true)
    private Integer dId;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
