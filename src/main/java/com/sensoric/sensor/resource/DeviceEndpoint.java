package com.sensoric.sensor.resource;

import com.sensoric.sensor.domain.command.RegisterDeviceCommand;
import com.sensoric.sensor.domain.command.RegisterSensorCommand;
import com.sensoric.sensor.domain.dto.RegisterDeviceDTO;
import com.sensoric.sensor.domain.dto.RegisterSensorDTO;
import com.sensoric.sensor.domain.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeviceEndpoint {
	private final DeviceService service;

	@Autowired
	public DeviceEndpoint(DeviceService service) {
		this.service = service;
	}

	@PostMapping(path = "/device")
	public RegisterDeviceDTO registerDevice(@RequestBody RegisterDeviceCommand command) {
		return service.registerDevice(command);
	}

	@PostMapping(path = "/device/{id}/sensor")
	public RegisterSensorDTO registerSensor(@PathVariable UUID id, @RequestBody RegisterSensorCommand command) {
		return service.registerSensor(command);
	}
}
