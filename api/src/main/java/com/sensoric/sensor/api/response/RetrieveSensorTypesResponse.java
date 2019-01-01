package com.sensoric.sensor.api.response;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public final class RetrieveSensorTypesResponse {
	private final UUID id;
	private final String name;
	@Data
	public static final class Type {

	}
}
