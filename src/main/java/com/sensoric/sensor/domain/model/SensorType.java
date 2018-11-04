package com.sensoric.sensor.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "sensor_types")
public class SensorType {
    @Id
    private UUID id;

    private String name;
}
