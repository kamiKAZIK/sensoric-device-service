package com.sensoric.sensor.domain.command;

import lombok.Data;

import java.util.UUID;

@Data
public final class RegisterSensorCommand {
	private final UUID deviceId;
	private final Sensor sensor;

	@Data
	public static final class Sensor {
		private final String name;
		private final UUID type;
	}
}
