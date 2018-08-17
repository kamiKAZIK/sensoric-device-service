package com.sensoric.sensor.domain.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@NodeEntity
public class Sensor {
	@Id
	private UUID id;

	private String name;
}
