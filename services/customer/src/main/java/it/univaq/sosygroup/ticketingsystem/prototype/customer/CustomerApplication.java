package it.univaq.sosygroup.ticketingsystem.prototype.customer;

import it.univaq.sosygroup.ticketingsystem.prototype.customer.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

	private final CustomerService service;

	public CustomerApplication(CustomerService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ok, i am running!");

		String instanceId = "iid";

		service.getEventsList(instanceId);

		service.getEventInfo(instanceId);

		service.selectTickets(instanceId);

		service.requestCheckout(instanceId);

		System.out.println("Process ended!");
	}
}
