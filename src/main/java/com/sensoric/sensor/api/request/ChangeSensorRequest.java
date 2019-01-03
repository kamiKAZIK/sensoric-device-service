package com.sensoric.sensor.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChangeSensorRequest {
	@NotBlank(message = "Sensor serial number must not be blank!")
	private String serialNumber;

	@NotBlank(message = "Sensor name must not be blank!")
	private String name;
}
