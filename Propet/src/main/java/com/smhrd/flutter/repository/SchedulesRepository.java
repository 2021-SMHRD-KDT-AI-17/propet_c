package com.smhrd.flutter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smhrd.flutter.model.Schedules;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Long> {
}
