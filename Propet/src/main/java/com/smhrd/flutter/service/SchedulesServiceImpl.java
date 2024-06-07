package com.smhrd.flutter.service;

import java.util.List;

import com.smhrd.flutter.model.Schedules;

public interface SchedulesServiceImpl {
	 	Schedules createSchedule(Schedules schedule);
	    List<Schedules> getAllSchedules();
	    Schedules getScheduleById(Long sidx);
	    void deleteSchedule(Long sidx);
}
