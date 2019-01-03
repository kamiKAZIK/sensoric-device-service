package com.sensoric.sensor.domain.command;

import lombok.Data;

import java.util.UUID;

@Data
public final class ChangeSensorCommand {
	private final UUID id;
	private final String serialNumber, name;
}
