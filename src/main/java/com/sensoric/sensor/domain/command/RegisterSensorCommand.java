package com.sensoric.sensor.domain.command;

import lombok.Data;

@Data
public final class RegisterSensorCommand {
	private final String serialNumber, name;
}
