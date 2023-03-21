package com.group.leavemanagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


enum LeaveStatus {Applied, Approved, Rejected}
@Entity
@Table(name = "leave1")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    @Column(name = "employee_id", nullable = false)
    private long employeeId;
    @Column(name = "manager_id", nullable = false)
    @Getter
    @Setter
    private long managerId;
    @Column(name = "start_date", nullable = false)
    @Getter
    @Setter
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    @Getter
    @Setter
    private LocalDate endDate;
    @Column(name = "num_of_leaves", nullable = false)
    @Getter
    @Setter
    private double numberOfLeaves;
    @Column(name = "leave_status", nullable = true)
    @Getter
    @Setter
    private String leaveStatus;
    @Column(name = "created_at", nullable = true)
    @Getter
    @Setter
    private LocalDate creationTime;
    @Column(name = "updated_at", nullable = true)
    @Getter
    @Setter
    private LocalDate updateTime;
    @Column(name = "remark", nullable = true)
    @Getter
    @Setter
    private String remark;
    @Column(name = "leave_type", nullable = false)
    @Getter
    @Setter
    private String leaveType;

    public Leave()
    {

    }
}
