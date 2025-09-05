package com.rrhh.reclutamiento_sevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@SpringBootApplication
@EnableR2dbcAuditing
public class ReclutamientoSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclutamientoSeviceApplication.class, args);
	}

}
