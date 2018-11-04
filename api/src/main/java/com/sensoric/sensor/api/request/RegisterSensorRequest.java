package com.sensoric.sensor.api.request;

import lombok.Data;

import java.util.UUID;

@Data
public class RegisterSensorRequest {
    private String name;
    private UUID type;
}
