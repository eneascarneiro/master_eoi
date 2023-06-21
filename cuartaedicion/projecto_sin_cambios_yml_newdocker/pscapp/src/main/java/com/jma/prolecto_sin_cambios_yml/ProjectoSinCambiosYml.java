package com.jma.prolecto_sin_cambios_yml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.jma.prolecto_sin_cambios_yml.config")
public class ProjectoSinCambiosYml {

	public static void main(String[] args) {
		SpringApplication.run(ProjectoSinCambiosYml.class, args);
	}

}
