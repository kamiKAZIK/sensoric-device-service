package com.sensoric.sensor.api;

import com.sensoric.sensor.api.request.ChangeSensorRequest;
import com.sensoric.sensor.api.request.RegisterSensorRequest;
import com.sensoric.sensor.api.response.ChangeSensorResponse;
import com.sensoric.sensor.api.response.RegisterSensorResponse;
import com.sensoric.sensor.api.response.ViewSensorResponse;
import com.sensoric.sensor.domain.command.*;
import com.sensoric.sensor.domain.dto.ChangeSensorDTO;
import com.sensoric.sensor.domain.dto.DeleteSensorDTO;
import com.sensoric.sensor.domain.dto.RegisterSensorDTO;
import com.sensoric.sensor.domain.dto.ViewSensorDTO;
import com.sensoric.sensor.domain.service.SensorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.text.MessageFormat;
import java.util.UUID;

@Configuration
class SensorApiConfiguration {
	@RestController
	static class SensorController {
		private final SensorGateway sensorGateway;

		SensorController(SensorGateway sensorGateway) {
			this.sensorGateway = sensorGateway;
		}

		@GetMapping(path = "/sensors")
		public void searchSensors(@RequestParam(required = false) String name, Pageable pageable) {

		}

		@PostMapping(path = "/sensor")
		public RegisterSensorResponse registerSensor(@Valid @RequestBody RegisterSensorRequest request) {
			return sensorGateway.registerSensor(new RegisterSensorCommand(request.getSerialNumber(), request.getName()));
		}

		@GetMapping(path = "/sensor/{id}")
		public ViewSensorResponse viewSensor(@PathVariable UUID id) {
			return sensorGateway.viewSensor(new ViewSensorCommand(id));
		}

		@PostMapping(path = "/sensor/{id}")
		public ChangeSensorResponse changeSensor(@PathVariable UUID id, @Valid @RequestBody ChangeSensorRequest request) {
			return sensorGateway.changeSensor(new ChangeSensorCommand(id, request.getSerialNumber(), request.getName()));
		}

		@DeleteMapping(path = "/sensor/{id}")
		public void deleteSensor(@PathVariable UUID id) {
			sensorGateway.deleteSensor(new DeleteSensorCommand(id));
		}
	}

	@MessagingGateway
	protected interface SensorGateway {
		@Gateway(requestChannel = "")
		RegisterSensorResponse searchSensors(SearchSensorsCommand command);

		@Gateway(requestChannel = "registerSensorFlow.input")
		RegisterSensorResponse registerSensor(RegisterSensorCommand command);

		@Gateway(requestChannel = "viewSensorFlow.input")
		ViewSensorResponse viewSensor(ViewSensorCommand command);

		@Gateway(requestChannel = "changeSensorFlow.input")
		ChangeSensorResponse changeSensor(ChangeSensorCommand command);

		@Gateway(requestChannel = "deleteSensorFlow.input")
		void deleteSensor(DeleteSensorCommand command);
	}

	@Bean
	protected IntegrationFlow registerSensorFlow(SensorService sensorService) {
		return f -> f
				.<RegisterSensorCommand>handle((p, h) -> sensorService.registerSensor(p))
				.<RegisterSensorDTO>log(LoggingHandler.Level.DEBUG, l -> MessageFormat.format("Registered sensor with ID: {0}", l.getPayload().getId()))
				.<RegisterSensorDTO, RegisterSensorResponse>transform(d -> new RegisterSensorResponse(d.getId(), d.getSerialNumber(), d.getName()));
	}

	@Bean
	protected IntegrationFlow viewSensorFlow(SensorService sensorService) {
		return f -> f
				.<ViewSensorCommand>handle((p, h) -> sensorService.viewSensor(p))
				.<ViewSensorDTO, ViewSensorResponse>transform(d -> new ViewSensorResponse(d.getId(), d.getSerialNumber(), d.getName()));
	}

	@Bean
	protected IntegrationFlow changeSensorFlow(SensorService sensorService) {
		return f -> f
				.<ChangeSensorCommand>handle((p, h) -> sensorService.changeSensor(p))
				.<ChangeSensorDTO>log(LoggingHandler.Level.DEBUG, l -> MessageFormat.format("Changed sensor with ID: {0}", l.getPayload().getId()))
				.<ChangeSensorDTO, ChangeSensorResponse>transform(d -> new ChangeSensorResponse(d.getId(), d.getSerialNumber(), d.getName()));
	}

	@Bean
	protected IntegrationFlow deleteSensorFlow(SensorService sensorService) {
		return f -> f
				.<DeleteSensorCommand>handle((p, h) -> sensorService.deleteSensor(p))
				.<DeleteSensorDTO>log(LoggingHandler.Level.DEBUG, l -> MessageFormat.format("Deleted sensor with ID: {0}", l.getPayload().getId()));
	}
}
