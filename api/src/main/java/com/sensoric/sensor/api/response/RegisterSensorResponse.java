package com.sensoric.sensor.api.response;

import lombok.Data;

import java.util.UUID;

@Data
public final class RegisterSensorResponse {
	private final UUID id;
	private final String name;
}
