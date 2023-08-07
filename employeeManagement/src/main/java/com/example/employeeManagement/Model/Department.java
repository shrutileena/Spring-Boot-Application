package com.example.employeeManagement.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "department_tbl")
public class Department {
    @Column(name = "dept_name")
    private String deptName;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private String deptId;

//    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Employee employee;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
