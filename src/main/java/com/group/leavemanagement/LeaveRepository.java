package com.group.leavemanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    @Query(value = "Select * from Leave1 l where l.manager_id = ?1", nativeQuery = true)
    List<Leave> findAllByManagerId(Long managerId);

    @Query(value = "Select * from Leave1 l where l.employee_id = :employeeId and l.start_date >= :dateStart", nativeQuery = true)
    List<Leave> findAllByEmployeeId(@Param("employeeId") Long employeeId, @Param("dateStart") LocalDate dateStart);

    @Query(value = "Select * from Leave1 l where l.employee_id = ?1 and l.leave_status = ?2", nativeQuery = true)
    List<Leave> findAllByLeaveStatus(Long employeeId, String leaveStatus);

    @Query(value = "Select * from Leave1 l where l.manager_id = ?1 and l.leave_status = ?2", nativeQuery = true)
    List<Leave> findAllByLeaveForManagerByStatus(Long managerId, String leaveStatus);

    @Query(value = "Select count(*) from Leave1 l where l.manager_id = ?1 and l.leave_status = ?2", nativeQuery = true)
    Long getLeaveCountByStatusForManager(Long managerId, String leaveStatus);

    @Query(value = "Select * from Leave1 l where l.employee_id = ?1", nativeQuery = true)
    List<Leave> findAllByEmpId(Long employeeId);
}
