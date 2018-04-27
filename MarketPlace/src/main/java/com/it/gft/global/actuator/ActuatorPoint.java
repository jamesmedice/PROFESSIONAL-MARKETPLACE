package com.it.gft.global.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;


@Component
@Endpoint(id = "tpm", enableByDefault = true)
public class ActuatorPoint {

    @ReadOperation
    public String archCreator() {
	return "{\"creator\": \"JAMES MEDICI\"}";
    }

}
