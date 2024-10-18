package br.com.renan.task_it.configs;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		packages("br.com.renan.task_it.controllers");
	}

}
