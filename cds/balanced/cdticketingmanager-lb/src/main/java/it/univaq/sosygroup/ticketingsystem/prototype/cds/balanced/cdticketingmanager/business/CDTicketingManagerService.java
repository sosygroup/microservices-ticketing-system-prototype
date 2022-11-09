package it.univaq.sosygroup.ticketingsystem.prototype.cds.balanced.cdticketingmanager.business;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CDTicketingManagerService {

    private final WebClient.Builder webClientBuilder;

    public CDTicketingManagerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String createTickets(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8150/ticketService/createTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String printTickets(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8120/printService/printTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String prepareTicketShipping(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8140/shipping/prepareTicketsShipping/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String ticketIssueCompleted(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8200/ticketPortalManager/ticketIssueCompleted/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }
}
