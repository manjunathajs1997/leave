package com.group.leavemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leave-type")
public class LeaveTypeController {
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;
    @PostMapping()
    public LeaveType createLeaveType(@Validated @RequestBody LeaveType leaveType)
    {
        return leaveTypeRepository.save(leaveType);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LeaveType> getLeaveTypeById(@PathVariable(value = "id") Long leaveTypeId)
    {
        try
        {
            LeaveType leaveType = leaveTypeRepository.findById(leaveTypeId).get();
            return ResponseEntity.ok().body(leaveType);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public List<LeaveType> getAllLeaveType()
    {
        return leaveTypeRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<LeaveType> deleteLeaveType(@PathVariable(value = "id") Long leaveTypeId)
    {
        try
        {
            LeaveType leaveType = leaveTypeRepository.findById(leaveTypeId).get();
            leaveTypeRepository.delete(leaveType);
            return ResponseEntity.ok().body(leaveType);
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<LeaveType> updateHoliday(@PathVariable(value = "id") Long leaveTypeId, @Validated @RequestBody LeaveType leaveType)
    {
        Optional<LeaveType> leaveToUpdate = leaveTypeRepository.findById(leaveTypeId);
        if(leaveToUpdate.isPresent())
        {
            LeaveType updatedLeaveType = leaveToUpdate.get();
            updatedLeaveType.setLeaveType(leaveType.getLeaveType());
            updatedLeaveType.setNumOfLeaves(leaveType.getNumOfLeaves());
            return ResponseEntity.ok().body(leaveTypeRepository.save(leaveType));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
