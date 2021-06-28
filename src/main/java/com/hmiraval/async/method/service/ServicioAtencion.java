package com.hmiraval.async.method.service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hmiraval.async.method.model.Paciente;

@Service
public class ServicioAtencion {
	
	private Logger logger = LoggerFactory.getLogger(ServicioAtencion.class);
	
	@Async("threadPoolExecutor")
	public CompletableFuture<String> atender(Paciente paciente){
		
		logger.info("Atendiendo al paciente: " + paciente.getNombre() + ", el cual presenta: " + paciente.getEnfermedad());
		
		int tiempo = ejecutarTiempoAtencion();
		
		return CompletableFuture.completedFuture("Se atendió al paciente: "
				+ paciente.getNombre() + " durante " + tiempo/1000 + " segundos");
	}
	
	public int ejecutarTiempoAtencion() {
		int tiempo = new Random().nextInt(10000);
		
		try {
			Thread.sleep(tiempo);
		}catch(InterruptedException ex) {
			logger.info("Ha ocurrido un error ", ex);
		}
		
		return tiempo;
	}

}
