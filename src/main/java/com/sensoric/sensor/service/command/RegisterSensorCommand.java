package com.sensoric.sensor.service.command;

import lombok.Data;

import java.util.UUID;

@Data
public final class RegisterSensorCommand {
    private UUID deviceId;
    private Sensor sensor;

    @Data
    public static final class Sensor {
        private String name;
        private UUID type;
    }
}
