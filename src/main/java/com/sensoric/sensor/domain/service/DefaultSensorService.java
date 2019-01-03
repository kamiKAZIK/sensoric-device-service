package com.sensoric.sensor.domain.service;

import com.sensoric.sensor.domain.command.ChangeSensorCommand;
import com.sensoric.sensor.domain.command.DeleteSensorCommand;
import com.sensoric.sensor.domain.command.RegisterSensorCommand;
import com.sensoric.sensor.domain.command.ViewSensorCommand;
import com.sensoric.sensor.domain.dto.ChangeSensorDTO;
import com.sensoric.sensor.domain.dto.DeleteSensorDTO;
import com.sensoric.sensor.domain.dto.RegisterSensorDTO;
import com.sensoric.sensor.domain.dto.ViewSensorDTO;
import com.sensoric.sensor.domain.model.Sensor;
import com.sensoric.sensor.domain.repository.SensorRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.MessageFormat;
import java.util.UUID;

@Service
class DefaultSensorService implements SensorService {
	private final SensorRepository sensorRepository;

	public DefaultSensorService(SensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}

	@Override
	public RegisterSensorDTO registerSensor(RegisterSensorCommand command) {
		Sensor sensor = sensorRepository.save(transform(command));

		return new RegisterSensorDTO(
				sensor.getId(),
				sensor.getSerialNumber(),
				sensor.getName()
		);
	}

	@Override
	public ViewSensorDTO viewSensor(ViewSensorCommand command) {
		Sensor sensor = retrieve(command.getId());

		return new ViewSensorDTO(
				sensor.getId(),
				sensor.getSerialNumber(),
				sensor.getName()
		);
	}

	@Override
	public ChangeSensorDTO changeSensor(ChangeSensorCommand command) {
		Sensor sensor = retrieve(command.getId());
		sensor.setSerialNumber(command.getSerialNumber());
		sensor.setName(command.getName());

		sensorRepository.save(sensor);

		return new ChangeSensorDTO(
				sensor.getId(),
				sensor.getSerialNumber(),
				sensor.getName()
		);
	}

	@Override
	public DeleteSensorDTO deleteSensor(DeleteSensorCommand command) {
		sensorRepository.deleteById(command.getId());

		return new DeleteSensorDTO(command.getId());
	}

	private Sensor transform(RegisterSensorCommand command) {
		Sensor sensor = new Sensor();
		sensor.setId(UUID.randomUUID());
		sensor.setSerialNumber(command.getSerialNumber());
		sensor.setName(command.getName());

		return sensor;
	}

	private Sensor retrieve(UUID id) {
		return sensorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Sensor with ID: {0} not found!", id)));
	}
}
