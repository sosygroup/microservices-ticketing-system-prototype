package it.univaq.sosygroup.ticketingsystem.prototype.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CustomerService {

    private final WebClient.Builder webClientBuilder;

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public CustomerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public void getEventsList(String instanceId) {
        logger.info(String.format("Choreography Instance %s: Sending getEventList at %s", instanceId, System.currentTimeMillis()));

        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8550/cdCustomer/getEvents/%s", instanceId))
                .retrieve().toEntity(String.class).block();

        logger.info(String.format("Choreography Instance %s: Received getEventList at %s", instanceId, System.currentTimeMillis()));
    }

    public void getEventInfo(String instanceId) {
        logger.info(String.format("Choreography Instance %s: Sending getEventInfo at %s", instanceId, System.currentTimeMillis()));
        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8550/cdCustomer/getEventInfo/%s", instanceId))
                .retrieve().toEntity(String.class).block();

        logger.info(String.format("Choreography Instance %s: Received getEventInfo at %s", instanceId, System.currentTimeMillis()));
    }

    public void selectTickets(String instanceId) {
        logger.info(String.format("Choreography Instance %s: Sending selectTickets at %s", instanceId, System.currentTimeMillis()));
        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8550/cdCustomer/selectTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    public void requestCheckout(String instanceId) {
        logger.info(String.format("Choreography Instance %s: Sending requestCheckout at %s", instanceId, System.currentTimeMillis()));
        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8550/cdCustomer/requestCheckout/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    public void ticketsReserved(String instanceId) {
        logger.info(String.format("Choreography Instance %s: Received ticketsReserved at %s", instanceId, System.currentTimeMillis()));
    }

    public void returnTicketsAndShippingInfo(String instanceId) {
        logger.info(String.format("Choreography Instance %s: Received returnTicketsAndShippingInfo at %s", instanceId, System.currentTimeMillis()));
    }
}
