package com.sensoric.sensor.domain.service;

import com.sensoric.sensor.domain.command.RegisterDeviceCommand;
import com.sensoric.sensor.domain.command.RegisterSensorCommand;
import com.sensoric.sensor.domain.dto.RegisterDeviceDTO;
import com.sensoric.sensor.domain.dto.RegisterSensorDTO;

public interface DeviceService {
	RegisterDeviceDTO registerDevice(RegisterDeviceCommand command);

	RegisterSensorDTO registerSensor(RegisterSensorCommand command);
}
