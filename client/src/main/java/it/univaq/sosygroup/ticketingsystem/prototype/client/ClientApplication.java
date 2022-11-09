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

		// The client runs a number of parallel instances (simulates a number of users)...
		// ...and repeats the runs until the total instances number is reached
		final int parallelInstances = 100;
		final int totalInstances = 10;

		for (int i = 0; i < totalInstances; i = i + parallelInstances) {

			String[] instanceIds = new String[parallelInstances];
			for (int j = 0; j<parallelInstances; j++) {
				instanceIds[j] = generateRandomId();
			}

			Arrays.stream(instanceIds).parallel().forEach(
					instanceId -> {
						System.out.printf("Running instance %s%n", instanceId);
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

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Instances completed");
	}

	private String generateRandomId() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		return RandomStringUtils.random(length, useLetters, useNumbers);
	}
}
