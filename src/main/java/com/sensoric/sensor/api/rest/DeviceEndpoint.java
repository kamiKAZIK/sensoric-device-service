package com.sensoric.sensor.api.rest;

import com.sensoric.sensor.domain.model.Device;
import com.sensoric.sensor.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class DeviceEndpoint {
    private final DeviceService service;

    @Autowired
    public DeviceEndpoint(DeviceService service) {
        this.service = service;
    }

    @GetMapping(name = "/devices")
    public Set<Device> fetchDevices() {
        return service.fetchDevices();
    }
}
