package com.hmiraval.async.method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync//Activa para cada metodo funcione dentro del pull de hilos
public class HmiravalAsyncMethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmiravalAsyncMethodApplication.class, args);
	}
	
	@Bean("threadPoolExecutor")
	public TaskExecutor getAsyncExecutor() {
		
		//Establecer el threadpool para ejecutar cada proceso asincrono
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);//minimo 2 hilos
		executor.setMaxPoolSize(2);//maximo 2 hilos
		executor.setQueueCapacity(100);//
		executor.setThreadNamePrefix("Async-");//prefijo async obligatorio
		return executor;
		
	}
	

}
