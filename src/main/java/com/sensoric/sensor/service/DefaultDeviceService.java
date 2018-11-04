package com.sensoric.sensor.service;

import com.sensoric.sensor.domain.model.Device;
import com.sensoric.sensor.domain.model.Sensor;
import com.sensoric.sensor.domain.repository.DeviceRepository;
import com.sensoric.sensor.domain.repository.SensorTypeRepository;
import com.sensoric.sensor.service.command.RegisterDeviceCommand;
import com.sensoric.sensor.service.command.RegisterSensorCommand;
import com.sensoric.sensor.service.dto.RegisterDeviceDTO;
import com.sensoric.sensor.service.dto.RegisterSensotDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultDeviceService implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final SensorTypeRepository sensorTypeRepository;

    @Autowired
    public DefaultDeviceService(DeviceRepository deviceRepository, SensorTypeRepository sensorTypeRepository) {
        this.deviceRepository = deviceRepository;
        this.sensorTypeRepository = sensorTypeRepository;
    }

    @Override
    public RegisterDeviceDTO registerDevice(RegisterDeviceCommand command) {
        Device device = new Device();
        device.setId(UUID.randomUUID());
        device.setName(command.getName());

        Device result = deviceRepository.save(device);

        RegisterDeviceDTO dto = new RegisterDeviceDTO();
        dto.setId(result.getId());
        dto.setName(result.getName());

        return dto;
    }

    @Override
    public RegisterSensotDTO registerSensor(RegisterSensorCommand command) {
        Device device = deviceRepository.findById(command.getDeviceId()).orElseThrow(() -> new IllegalArgumentException("Device not found!"));

        Sensor sensor = new Sensor();
        sensor.setId(UUID.randomUUID());
        sensor.setName(command.getSensor().getName());
        sensor.setSensorType(sensorTypeRepository.findById(command.getSensor().getType()).orElseThrow(() -> new IllegalArgumentException("Sensor type not found!")));

        device.addSensor(sensor);

        deviceRepository.save(device);

        RegisterSensotDTO.Type dtoType = new RegisterSensotDTO.Type();
        dtoType.setId(sensor.getSensorType().getId());
        dtoType.setName(sensor.getSensorType().getName());

        RegisterSensotDTO dto = new RegisterSensotDTO();
        dto.setId(sensor.getId());
        dto.setName(sensor.getName());
        dto.setType(dtoType);

        return dto;
    }
}
