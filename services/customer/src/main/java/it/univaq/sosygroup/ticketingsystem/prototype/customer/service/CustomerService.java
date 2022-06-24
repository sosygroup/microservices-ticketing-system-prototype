package it.univaq.sosygroup.ticketingsystem.prototype.customer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerService {

    private final WebClient.Builder webClientBuilder;

    public CustomerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public void getEventsList(String instanceId) {
        System.out.printf("Customer - Choreography Instance %s%n: Sending getEventList at %s%n", instanceId, System.currentTimeMillis());
        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8550/cdCustomer/getEvents/%s", instanceId))
                .retrieve().toEntity(String.class).block();

        System.out.printf("Customer - Choreography Instance %s%n: Received getEventList at %s%n", instanceId, System.currentTimeMillis());

    }

    public void getEventInfo(String instanceId) {
        System.out.printf("Customer - Choreography Instance %s%n: Sending getEventInfo at %s%n", instanceId, System.currentTimeMillis());
        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8550/cdCustomer/getEventInfo/%s", instanceId))
                .retrieve().toEntity(String.class).block();

        System.out.printf("Customer - Choreography Instance %s%n: Received getEventInfo at %s%n", instanceId, System.currentTimeMillis());
    }

    public void selectTickets(String instanceId) {
        System.out.printf("Customer - Choreography Instance %s%n: Sending selectTickets at %s%n", instanceId, System.currentTimeMillis());
        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8550/cdCustomer/selectTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    public void requestCheckout(String instanceId) {
        System.out.printf("Customer - Choreography Instance %s%n: Sending requestCheckout at %s%n", instanceId, System.currentTimeMillis());
        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8550/cdCustomer/requestCheckout/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    public void ticketsReserved(String instanceId) {
        System.out.printf("Customer - Choreography Instance %s%n: Received ticketsReserved at %s%n", instanceId, System.currentTimeMillis());
    }

    public void returnTicketsAndShippingInfo(String instanceId) {
        System.out.printf("Customer - Choreography Instance %s%n: Received returnTicketsAndShippingInfo at %s%n", instanceId, System.currentTimeMillis());
    }
}
