package com.chubbserviceprocess.webservice.controller;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChubbServiceProcessController {
	private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Value("ChubbServiceProcessController Service")
    private String greetingMessage;
	
    @GetMapping("/index")
    public String execute() {
    	LOGGER.debug("ChubbServiceProcessController.execute");
    	
        return greetingMessage;
    }
}
