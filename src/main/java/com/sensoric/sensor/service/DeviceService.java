package com.sensoric.sensor.service;

import com.sensoric.sensor.service.command.RegisterDeviceCommand;
import com.sensoric.sensor.service.command.RegisterSensorCommand;
import com.sensoric.sensor.service.dto.RegisterDeviceDTO;
import com.sensoric.sensor.service.dto.RegisterSensotDTO;

public interface DeviceService {
    RegisterDeviceDTO registerDevice(RegisterDeviceCommand command);

    RegisterSensotDTO registerSensor(RegisterSensorCommand command);
}
