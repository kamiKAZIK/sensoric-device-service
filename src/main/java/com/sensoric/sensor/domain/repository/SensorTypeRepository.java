package com.sensoric.sensor.domain.repository;

import com.sensoric.sensor.domain.model.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SensorTypeRepository extends JpaRepository<SensorType, UUID> {
}
