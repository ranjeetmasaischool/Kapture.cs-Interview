package com.example.demo.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Calls;

public interface CallRepo extends JpaRepository<Calls, Integer> {

	@Query(value = "SELECT HOUR(c.start_time) AS hour FROM calls c GROUP BY HOUR(c.start_time) ORDER BY COUNT(c.id) DESC LIMIT 1", nativeQuery = true)
	Integer findHighestCallVolumeByHour();

	@Query(value = "SELECT HOUR(c.start_time) AS hour FROM calls c GROUP BY HOUR(c.start_time) ORDER BY SUM(c.duration) DESC LIMIT 1", nativeQuery = true)
	Integer findLongestCallsByHour();

	@Query(value = "SELECT WEEKDAY(c.start_time) AS dayOfWeek FROM Calls c GROUP BY WEEKDAY(c.start_time) ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
	Integer findHighestCallVolumeByDay();

	@Query(value = "SELECT WEEKDAY(c.start_time)  as dayOfWeek FROM calls c GROUP BY WEEKDAY(c.start_time) ORDER BY SUM(c.duration) DESC LIMIT 1", nativeQuery = true)
	Integer findLongestCallsByDay();

}
