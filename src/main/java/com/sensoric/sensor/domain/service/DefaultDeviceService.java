package com.sensoric.sensor.domain.service;

import com.sensoric.sensor.domain.command.RegisterDeviceCommand;
import com.sensoric.sensor.domain.command.RegisterSensorCommand;
import com.sensoric.sensor.domain.dto.RegisterDeviceDTO;
import com.sensoric.sensor.domain.dto.RegisterSensorDTO;
import com.sensoric.sensor.domain.model.Device;
import com.sensoric.sensor.domain.model.Sensor;
import com.sensoric.sensor.domain.repository.DeviceRepository;
import com.sensoric.sensor.domain.repository.SensorTypeRepository;
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

		return new RegisterDeviceDTO(
				result.getId(),
				result.getName()
		);
	}

	@Override
	public RegisterSensorDTO registerSensor(RegisterSensorCommand command) {
		Device device = deviceRepository.findById(command.getDeviceId()).orElseThrow(() -> new IllegalArgumentException("Device not found!"));

		Sensor sensor = new Sensor();
		sensor.setId(UUID.randomUUID());
		sensor.setName(command.getSensor().getName());
		sensor.setSensorType(sensorTypeRepository.findById(command.getSensor().getType()).orElseThrow(() -> new IllegalArgumentException("Sensor type not found!")));

		device.addSensor(sensor);

		deviceRepository.save(device);

		return new RegisterSensorDTO(
				sensor.getId(),
				sensor.getName(),
				new RegisterSensorDTO.Type(sensor.getSensorType().getId(), sensor.getSensorType().getName())
		);
	}
}
