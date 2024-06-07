package com.smhrd.flutter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smhrd.flutter.model.Schedules;

@Repository
public interface SchedulesRepository extends JpaRepository<Schedules, Long> {
	List<Schedules> findByUidx(Long uidx);
}
