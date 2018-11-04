package com.sensoric.sensor.domain.repository;

import com.sensoric.sensor.domain.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
