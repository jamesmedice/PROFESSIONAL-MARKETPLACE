package com.it.gft.global.actuator;

import org.springframework.boot.actuate.health.*;
import org.springframework.stereotype.Component;

@Component
public class MainHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
	return Health.down().withDetail("Memory Usage", "Limit reached").build();
    }

}
