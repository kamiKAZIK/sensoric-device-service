package com.sensoric.sensor.api.request;

import lombok.Data;

import java.util.UUID;

@Data
public final class RegisterSensorRequest {
	private final String name;
	private final UUID type;
}
