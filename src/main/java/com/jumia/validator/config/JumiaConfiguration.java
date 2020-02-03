package com.jumia.validator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import com.jumia.validator.lib.properties.JumiaProperties;

@Configuration
@EnableConfigurationProperties({ JumiaProperties.class })
public class JumiaConfiguration {

	@Autowired
	protected JumiaProperties jumiaProperties;

	public JumiaProperties getJumiaProperties() {
		return jumiaProperties;
	}

	@Bean(name = "applicationEventMulticaster")
	public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
		SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
		eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return eventMulticaster;
	}
}
