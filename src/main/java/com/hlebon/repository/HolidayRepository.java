package com.hlebon.repository;

import com.hlebon.repository.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

    boolean existsByMonthAndDayOfMonth(Month month, int dayOfMonth);

}
