package it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdcustomer.business;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CDCustomerService {

    private final WebClient.Builder webClientBuilder;

    public CDCustomerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String getEvents(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8100/eventCatalog/getEvents/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String getEventInfo(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8100/eventCatalog/getEventInfo/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String selectTickets(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8200/ticketPortalManager/selectTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String requestCheckout(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8200/ticketPortalManager/requestCheckout/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }
}
