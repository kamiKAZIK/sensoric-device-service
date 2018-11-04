package com.sensoric.sensor.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "devices")
public class Device {
    @Id
    private UUID id;

    private String name;

    @JoinColumn(name = "device_id", referencedColumnName = "id", nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sensor> sensors = new ArrayList<>();

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }
}
