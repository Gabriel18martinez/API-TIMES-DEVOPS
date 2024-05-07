package com.example.time.repository;

import com.example.time.model.Times;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.UUID;

public interface TimesRepository extends JpaRepository<Times, UUID> {
}
