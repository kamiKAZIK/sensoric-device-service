package com.sensoric.sensor.domain.repository;

import com.sensoric.sensor.domain.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SensorRepository extends JpaRepository<Sensor, UUID> {
}
