package com.sensoric.sensor.resource;

import com.sensoric.sensor.domain.model.Device;
import com.sensoric.sensor.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(name = "/devices")
@RestController
public class DeviceEndpoint {
    private final DeviceService service;

    @Autowired
    public DeviceEndpoint(DeviceService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Device> fetchDevices(Pageable pageable) {
        return service.fetchDevices(pageable);
    }
}
