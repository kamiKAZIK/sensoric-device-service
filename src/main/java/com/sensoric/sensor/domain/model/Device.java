package com.sensoric.sensor.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "devices")
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String serialNumber;

	@OneToMany
	private List<Sensor> sensors;
}
