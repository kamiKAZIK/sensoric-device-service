package com.sensoric.sensor.service;

import com.sensoric.sensor.domain.model.Device;
import com.sensoric.sensor.domain.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DefaultDeviceService implements DeviceService {
    private final DeviceRepository repository;

    @Autowired
    public DefaultDeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Device> fetchDevices(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
