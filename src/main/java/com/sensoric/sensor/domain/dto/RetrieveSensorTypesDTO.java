package com.sensoric.sensor.domain.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.UUID;

@Data
public final class RetrieveSensorTypesDTO {
	private final Page<Type> types;

	@Data
	public static final class Type {
		private final UUID id;
		private final String name;
	}
}
