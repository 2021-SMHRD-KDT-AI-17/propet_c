package com.smhrd.flutter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smhrd.flutter.model.Schedules;
import com.smhrd.flutter.service.SchedulesService;

import java.util.List;

@RestController
public class SchedulesController {

    @Autowired
    private SchedulesService scheduleService;

    @PostMapping("/schedulesCreate")
    public Schedules createSchedule(@RequestBody Schedules schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @GetMapping("/getAllSchedules")
    public List<Schedules> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/getSchedules/{sidx}")
    public Schedules getScheduleById(@PathVariable("sidx") Long sidx) {
        return scheduleService.getScheduleById(sidx);
    }

    @DeleteMapping("/deleteSchedules/{sidx}")
    public void deleteSchedule(@PathVariable("sidx") Long sidx) {
        scheduleService.deleteSchedule(sidx);
    }
}
