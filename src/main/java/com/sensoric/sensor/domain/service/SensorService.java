package com.sensoric.sensor.domain.service;

import com.sensoric.sensor.domain.command.ChangeSensorCommand;
import com.sensoric.sensor.domain.command.DeleteSensorCommand;
import com.sensoric.sensor.domain.command.RegisterSensorCommand;
import com.sensoric.sensor.domain.command.ViewSensorCommand;
import com.sensoric.sensor.domain.dto.ChangeSensorDTO;
import com.sensoric.sensor.domain.dto.DeleteSensorDTO;
import com.sensoric.sensor.domain.dto.RegisterSensorDTO;
import com.sensoric.sensor.domain.dto.ViewSensorDTO;

public interface SensorService {
	RegisterSensorDTO registerSensor(RegisterSensorCommand command);

	ViewSensorDTO viewSensor(ViewSensorCommand command);

	ChangeSensorDTO changeSensor(ChangeSensorCommand command);

	DeleteSensorDTO deleteSensor(DeleteSensorCommand command);
}
