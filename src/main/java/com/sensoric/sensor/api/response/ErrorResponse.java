package com.sensoric.sensor.api.response;

import lombok.Data;

@Data
public class ErrorResponse {
	private final int code;
	private final String message;
}
