package com.sensoric.sensor.domain.command;

import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
public final class RetrieveSensorTypesCommand {
	private final String fragment;
	private final Pageable pageable;
}
