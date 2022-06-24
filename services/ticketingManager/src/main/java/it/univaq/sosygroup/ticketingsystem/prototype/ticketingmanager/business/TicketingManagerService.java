package it.univaq.sosygroup.ticketingsystem.prototype.ticketingmanager.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class TicketingManagerService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Ticketing Manager instance #" + instanceNumber);
    }

    private final WebClient.Builder webClientBuilder;

    public TicketingManagerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String issueTickets(String instanceId) {
        System.out.printf("[Choreography instance %s] Issue Tickets on Ticketing Manager instance %s%n", instanceId, instanceNumber);

        System.out.println("Performed calls:");

        ResponseEntity<String> createTicketsResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8450/cdTicketingManager/createTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(createTicketsResponse);

        ResponseEntity<String> printTicketsResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8450/cdTicketingManager/printTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(printTicketsResponse);

        ResponseEntity<String> ticketShippingRepsonse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8450/cdTicketingManager/prepareTicketShipping/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(ticketShippingRepsonse);

        ResponseEntity<String> issueTicketsResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8450/cdTicketingManager/ticketIssueCompleted/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(issueTicketsResponse);
        System.out.printf("[Choreography instance %s] Ended Issue Tickets", instanceId);

        return String.format("[Choreography instance %s] Issue Tickets on Ticketing Manager instance %s%n", instanceId, instanceNumber);
    }
}
