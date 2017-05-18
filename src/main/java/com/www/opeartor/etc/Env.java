package com.www.opeartor.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:app.properties")
public class Env {
	
	@Autowired
	Environment environment;
	
	public String getKey(String key) {
		return environment.getProperty(key);
	}
}
