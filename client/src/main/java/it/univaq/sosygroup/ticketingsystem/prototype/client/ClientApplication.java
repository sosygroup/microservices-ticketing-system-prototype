package it.univaq.sosygroup.ticketingsystem.prototype.client;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	private final WebClient.Builder webClientBuilder;

	public ClientApplication(WebClient.Builder webClientBuilder) {
		this.webClientBuilder = webClientBuilder;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) {

		int instances = 10;
		String[] instanceIds = new String[instances];
		for (int i = 0; i<instances; i++) {
			instanceIds[i] = generateRandomId();
		}

		Arrays.stream(instanceIds).parallel().forEach(
				instanceId -> {
					webClientBuilder.build().get()
					.uri(String.format("http://localhost:8888/customer/invokeGetEventsList/%s", instanceId))
					.retrieve().toEntity(String.class).block();

					webClientBuilder.build().get()
							.uri(String.format("http://localhost:8888/customer/invokeGetEventInfo/%s", instanceId))
							.retrieve().toEntity(String.class).block();

					webClientBuilder.build().get()
							.uri(String.format("http://localhost:8888/customer/invokeSelectTickets/%s", instanceId))
							.retrieve().toEntity(String.class).block();

					webClientBuilder.build().get()
							.uri(String.format("http://localhost:8888/customer/invokeRequestCheckout/%s", instanceId))
							.retrieve().toEntity(String.class).block();
				}
		);
	}

	private String generateRandomId() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		return RandomStringUtils.random(length, useLetters, useNumbers);
	}
}
