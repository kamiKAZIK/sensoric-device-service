package com.sensoric.sensor.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public final class RegisterSensotDTO {
    private UUID id;
    private String name;
    private Type type;

    @Data
    public static final class Type {
        private UUID id;
        private String name;
    }
}
