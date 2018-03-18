package com.sensoric.sensor.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    private UUID id;

    private String name;

    private Location location;

    private SensorType type;
}
