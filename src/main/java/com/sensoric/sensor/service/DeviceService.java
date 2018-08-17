package com.sensoric.sensor.service;

import com.sensoric.sensor.domain.model.Device;

import java.util.Set;

public interface DeviceService {
    Set<Device> fetchDevices();
}
