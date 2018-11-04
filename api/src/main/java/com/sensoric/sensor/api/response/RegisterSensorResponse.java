package com.sensoric.sensor.api.response;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterSensorResponse {
    private UUID id;
    private String name;
}
