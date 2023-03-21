package com.group.leavemanagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "holiday")
public class Holiday {
    @Id
    @Getter
    @Setter
    private long id;
    @Column(name = "date", nullable = false)
    @Getter
    @Setter
    private LocalDate date;

    @Column(name = "region", nullable = false)
    @Getter
    @Setter
    private String region;

    @Column(name = "description", nullable = true)
    @Getter
    @Setter
    private String description;

    @Column(name = "country", nullable = true)
    @Getter
    @Setter
    private String country;
    public Holiday()
    {

    }
}
