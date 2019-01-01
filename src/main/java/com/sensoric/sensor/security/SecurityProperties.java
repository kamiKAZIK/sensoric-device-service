package com.sensoric.sensor.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "sensoric.security")
class SecurityProperties {
	private UserProperties user, manager;

	List<UserProperties> getUsers() {
		return Collections.unmodifiableList(Arrays.asList(user, manager));
	}

	@Getter
	@Setter
	static final class UserProperties {
		private String name, password;
		private String[] roles;
	}
}
