package com.group.leavemanagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "leave_type")
public class LeaveType {
    @Id
    @Getter
    @Setter
    private long id;

    @Column(name = "leave_type", nullable = false)
    @Getter
    @Setter
    private String leaveType;
    @Column(name = "num_of_leavs", nullable = false)
    @Getter
    @Setter
    private int numOfLeaves;
}
