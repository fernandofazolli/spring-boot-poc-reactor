package br.com.spring.fazolli.springbootpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.bus.EventBus;


@SpringBootApplication
public class SpringBootPocApplication {

	@Bean
	EventBus createEventBus() {
		return EventBus.create();
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootPocApplication.class, args);
	}
}
