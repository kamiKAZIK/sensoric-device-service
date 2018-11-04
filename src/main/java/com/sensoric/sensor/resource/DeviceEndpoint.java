package com.sensoric.sensor.resource;

import com.sensoric.sensor.api.request.RegisterDeviceRequest;
import com.sensoric.sensor.api.request.RegisterSensorRequest;
import com.sensoric.sensor.api.response.RegisterDeviceResponse;
import com.sensoric.sensor.api.response.RegisterSensorResponse;
import com.sensoric.sensor.service.DeviceService;
import com.sensoric.sensor.service.command.RegisterDeviceCommand;
import com.sensoric.sensor.service.command.RegisterSensorCommand;
import com.sensoric.sensor.service.dto.RegisterDeviceDTO;
import com.sensoric.sensor.service.dto.RegisterSensotDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class DeviceEndpoint {
    private final DeviceService service;

    @Autowired
    public DeviceEndpoint(DeviceService service) {
        this.service = service;
    }

    @PostMapping(path = "/device")
    public RegisterDeviceResponse registerDevice(@RequestBody RegisterDeviceRequest request) {
        RegisterDeviceCommand command = new RegisterDeviceCommand();
        command.setName(request.getName());

        RegisterDeviceDTO dto = service.registerDevice(command);

        RegisterDeviceResponse response = new RegisterDeviceResponse();
        response.setId(dto.getId());
        response.setName(dto.getName());

        return response;
    }

    @PostMapping(path = "/device/{id}/sensor")
    public RegisterSensorResponse registerSensor(@PathVariable UUID id, @RequestBody RegisterSensorRequest request) {
        RegisterSensorCommand.Sensor commandSensor = new RegisterSensorCommand.Sensor();
        commandSensor.setName(request.getName());
        commandSensor.setType(request.getType());

        RegisterSensorCommand command = new RegisterSensorCommand();
        command.setDeviceId(id);
        command.setSensor(commandSensor);

        RegisterSensotDTO dto = service.registerSensor(command);

        RegisterSensorResponse response = new RegisterSensorResponse();
        response.setId(dto.getId());
        response.setName(dto.getName());

        return response;
    }
}
