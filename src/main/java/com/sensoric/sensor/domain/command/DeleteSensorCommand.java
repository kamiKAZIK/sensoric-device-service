package com.sensoric.sensor.domain.command;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteSensorCommand {
	private final UUID id;
}
