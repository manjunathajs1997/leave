package com.group.leavemanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long>{
}
