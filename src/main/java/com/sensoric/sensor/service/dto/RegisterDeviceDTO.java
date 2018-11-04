package com.sensoric.sensor.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public final class RegisterDeviceDTO {
    private UUID id;
    private String name;
}
