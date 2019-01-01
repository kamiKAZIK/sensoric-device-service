package com.sensoric.sensor.domain.service;

import com.querydsl.core.types.dsl.Expressions;
import com.sensoric.sensor.domain.command.RetrieveSensorTypesCommand;
import com.sensoric.sensor.domain.dto.RetrieveSensorTypesDTO;
import com.sensoric.sensor.domain.model.QSensorType;
import com.sensoric.sensor.domain.model.SensorType;
import com.sensoric.sensor.domain.repository.SensorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultTypeService implements TypeService {
	private final SensorTypeRepository sensorTypeRepository;

	@Autowired
	public DefaultTypeService(SensorTypeRepository sensorTypeRepository) {
		this.sensorTypeRepository = sensorTypeRepository;
	}

	@Override
	public RetrieveSensorTypesDTO retrieveSensorTypes(RetrieveSensorTypesCommand command) {
		Page<SensorType> sensorTypes = sensorTypeRepository.findAll(
				Optional.ofNullable(command.getFragment())
						.map(QSensorType.sensorType.name::contains)
						.orElse(Expressions.asBoolean(true).isTrue()),
				command.getPageable()
		);

		return new RetrieveSensorTypesDTO(sensorTypes.map(s -> new RetrieveSensorTypesDTO.Type(s.getId(), s.getName())));
	}
}
