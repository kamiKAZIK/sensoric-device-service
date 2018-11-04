package com.sensoric.sensor.service;

import com.sensoric.sensor.domain.model.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeviceService {
    Page<Device> fetchDevices(Pageable pageable);
}
