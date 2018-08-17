package com.sensoric.sensor.domain.repository;

import com.sensoric.sensor.domain.model.Device;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface DeviceRepository extends Neo4jRepository<Device, UUID> {
}
