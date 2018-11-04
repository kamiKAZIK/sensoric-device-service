package com.sensoric.sensor.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    private UUID id;

    private String name;

    @ManyToOne
    private SensorType sensorType;
}
