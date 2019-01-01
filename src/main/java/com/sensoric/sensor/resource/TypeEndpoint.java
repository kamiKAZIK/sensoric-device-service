package com.sensoric.sensor.resource;

import com.sensoric.sensor.domain.command.RetrieveSensorTypesCommand;
import com.sensoric.sensor.domain.dto.RetrieveSensorTypesDTO;
import com.sensoric.sensor.domain.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/type")
public class TypeEndpoint {
	private final TypeService typeService;

	@Autowired
	public TypeEndpoint(TypeService typeService) {
		this.typeService = typeService;
	}

	@GetMapping(path = "/sensor")
	public Page<RetrieveSensorTypesDTO.Type> retrieveSensorTypes(Pageable pageable) {
		return typeService.retrieveSensorTypes(new RetrieveSensorTypesCommand(null, pageable)).getTypes();
	}
}
