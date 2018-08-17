package com.sensoric.sensor.domain.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.Id;

import java.util.Set;
import java.util.UUID;

@NodeEntity
public class Device {
    @Id
    private UUID id;

    private String name;

    @Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
    Set<Sensor> sensors;
}
