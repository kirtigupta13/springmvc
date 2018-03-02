package com.infotech.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String getModelObject()
	{
		return "this is model object from service";
	}
}
