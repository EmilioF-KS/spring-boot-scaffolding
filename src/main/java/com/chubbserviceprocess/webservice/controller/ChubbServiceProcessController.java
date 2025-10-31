package com.chubbserviceprocess.webservice.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

import com.chubb.location.library.interfaces.SoapClientInterface;

@RestController
@RequestMapping("/api")
public class ChubbServiceProcessController {
	private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Value("ChubbServiceProcessController Service")
    private String greetingMessage;
	
    @GetMapping("/index")
    public String execute() {
    	LOGGER.debug("ChubbServiceProcessController.execute");
    	
    	try {    	    	
	    	Class<?> clazz = Class.forName("com.chubb.location.library.LocationRetrievalLOC3X1BClient");
	        Object instance = clazz.getDeclaredConstructor().newInstance();
	        LOGGER.debug("instance : " + instance);
	    		
	    } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    	
        return greetingMessage;
    }
}
