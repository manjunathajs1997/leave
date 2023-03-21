package com.group.leavemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PatchMapping("/{id}")
    public ResponseEntity<Employee> updateLeaveBalance(@PathVariable(value = "id") Long employeeId, @Validated @RequestBody Employee employee) {
        try {
            Employee employeeToUpdate = employeeRepository.findById(employeeId).get();
            employeeToUpdate.setLeaveBalance(employee.getLeaveBalance());
            return new ResponseEntity<Employee>(employeeRepository.save(employeeToUpdate), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/leavebalance/{id}")
    public ResponseEntity  getLeaveBalance(@PathVariable(value = "id") Long employeeId) {
        try {
            Employee employee = employeeRepository.findById(employeeId).get();
            return ResponseEntity.ok(employee.getLeaveBalance());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
