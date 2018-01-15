package com.it.gft.global.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.it.gft.global.message.gateway.EmployeeGTW;
import com.it.gft.global.model.Employee;

@RestController
@RequestMapping(path = BaseProtectedApi.PREFIX_PROTECTED + "/market")
public class EmployeeController {

    @Autowired(required = true)
    private EmployeeGTW employeeGTW;

    @RequestMapping(value = "/ids", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message<List<Employee>> findClients(@RequestBody List<String> ids, Principal principal) {
	Message<List<String>> request = new GenericMessage<List<String>>(ids);
	return employeeGTW.findEmployees(request);
    }

}
