package com.sensoric.sensor.domain.service;

import com.sensoric.sensor.domain.command.RetrieveSensorTypesCommand;
import com.sensoric.sensor.domain.dto.RetrieveSensorTypesDTO;

public interface TypeService {
	RetrieveSensorTypesDTO retrieveSensorTypes(RetrieveSensorTypesCommand command);
}
