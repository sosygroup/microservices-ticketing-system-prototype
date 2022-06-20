package it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdticketingmanager.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CDTicketingManagerService {

    private final WebClient.Builder webClientBuilder;

    public CDTicketingManagerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public void createTickets(String instanceId) {

        // Call to Ticket Service

        String result = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8150/ticketService/createTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block().getBody();
        System.out.println(result);
    }

    public void printTickets(String instanceId) {
        // TODO Call to Print Service
    }

    public void prepareTicketShipping(String instanceId) {
        // TODO Call to Shipping
    }

    public void completeTicketIssue(String instanceId) {
        // TODO Call to Ticket Portal Manager
    }
}
