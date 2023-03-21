package com.group.leavemanagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Getter
    @Setter
    private long id;
    @Column(name = "employee_name", nullable = false)
    @Getter
    @Setter
    private String employeeName;

    @Column(name = "manager_id", nullable = false)
    @Getter
    @Setter
    private long managerId;

    @Column(name = "joining_date", nullable = false)
    @Getter
    @Setter
    private Date joiningDate;

    @Column(name = "user_id", nullable = false)
    @Getter
    @Setter
    private String userId;

    @Column(name = "leave_balance", nullable = false)
    @Getter
    @Setter
    private String leaveBalance;

    public Employee()
    {

    }
}
