package com.sensoric.sensor.api.response;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterDeviceResponse {
    private UUID id;
    private String name;
}
