package com.sensoric.sensor.domain.command;

import lombok.Data;

@Data
public final class RegisterDeviceCommand {
	private final String name;
}
