package com.sensoric.sensor.domain.repository;

import com.sensoric.sensor.domain.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
