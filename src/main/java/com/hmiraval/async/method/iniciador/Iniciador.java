package com.hmiraval.async.method.iniciador;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hmiraval.async.method.model.Paciente;
import com.hmiraval.async.method.service.ServicioAtencion;



@Component
public class Iniciador implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(Iniciador.class);
	
	@Autowired
	private ServicioAtencion servicioAtencion;

	@Override
	public void run(String... args) throws Exception {
		
		CompletableFuture<String> atencion1 = servicioAtencion.atender(new Paciente("Juan", "Gripe"));
		CompletableFuture<String> atencion2 = servicioAtencion.atender(new Paciente("Humberto", "Dolor de cabeza"));
		CompletableFuture<String> atencion3 = servicioAtencion.atender(new Paciente("Jose", "Dolor de estomago"));
		CompletableFuture<String> atencion4 = servicioAtencion.atender(new Paciente("Jesus", "Infección estomacal"));
		
		CompletableFuture.allOf(atencion1,atencion2,atencion3,atencion4).join();
		
		logger.info("Mostrando Estadisticas");
		
		logger.info(atencion1.get());
		logger.info(atencion2.get());
		logger.info(atencion3.get());
		logger.info(atencion4.get());
		
		
	}


}
