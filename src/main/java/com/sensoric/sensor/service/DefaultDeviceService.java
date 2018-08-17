package com.sensoric.sensor.service;

import com.sensoric.sensor.domain.model.Device;
import com.sensoric.sensor.domain.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DefaultDeviceService implements DeviceService {
    private final DeviceRepository repository;

    @Autowired
    public DefaultDeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Device> fetchDevices() {
        Set<Device> devices = new HashSet<>();
        repository.findAll().forEach(devices::add);

        return devices;
    }
}
