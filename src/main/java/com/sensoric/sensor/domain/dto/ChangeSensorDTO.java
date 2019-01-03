package com.sensoric.sensor.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ChangeSensorDTO {
	private final UUID id;

	private final String serialNumber, name;
}
