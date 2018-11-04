package com.sensoric.sensor.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "devices")
public class Device {
    @Id
    private UUID id;

    private String name;

    @OneToMany
    private Set<Sensor> sensors;
}
