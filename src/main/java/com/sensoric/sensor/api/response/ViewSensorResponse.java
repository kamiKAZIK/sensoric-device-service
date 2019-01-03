package com.sensoric.sensor.api.response;

import lombok.Data;

import java.util.UUID;

@Data
public class ViewSensorResponse {
	private final UUID id;
	private final String serialNumber, name;
}
