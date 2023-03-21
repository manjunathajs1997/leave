package com.group.leavemanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/holiday")
public class HolidayController {
    @Autowired
    private HolidayRepository holidayRepository;
    @PostMapping()
    public Holiday createHoliday(@Validated @RequestBody Holiday holiday)
    {
        return holidayRepository.save(holiday);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Holiday> getHolidayById(@PathVariable(value = "id") Long holidayId)
    {
        Optional<Holiday> holiday = holidayRepository.findById(holidayId);
        if(holiday.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
        {
            return ResponseEntity.ok().body(holiday.get());
        }
    }

    @GetMapping("/")
    public List<Holiday> getAllHoliday()
    {
        return holidayRepository.findAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Holiday> deleteHoliday(@PathVariable(value = "id") Long holidayId)
    {
        Optional<Holiday> holiday = holidayRepository.findById(holidayId);
        Map<String, Boolean> response = new HashMap<>();
        if(holiday.isPresent())
        {
            holidayRepository.delete(holiday.get());
            return ResponseEntity.ok().body(holiday.get());
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable(value = "id") Long holidayId, @Validated @RequestBody Holiday holiday)
    {
        Optional<Holiday> holidayToUpdate = holidayRepository.findById(holidayId);
        if(holidayToUpdate.isPresent())
        {
            Holiday updatedHoliday = holidayToUpdate.get();
            updatedHoliday.setDate(holiday.getDate());
            updatedHoliday.setDescription(holiday.getDescription());
            updatedHoliday.setRegion(holiday.getRegion());
            return ResponseEntity.ok().body(holidayRepository.save(updatedHoliday));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
