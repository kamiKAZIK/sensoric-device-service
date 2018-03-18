package com.sensoric.sensor.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "sensor_types")
public class SensorType {
    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Name name;

    public enum Name {
        TEMPERATURE,
        HUMIDITY
    }
}