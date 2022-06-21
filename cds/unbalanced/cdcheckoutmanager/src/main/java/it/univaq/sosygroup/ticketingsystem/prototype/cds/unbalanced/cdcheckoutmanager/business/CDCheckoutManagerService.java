package it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdcheckoutmanager.business;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CDCheckoutManagerService {

    private final WebClient.Builder webClientBuilder;

    public CDCheckoutManagerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String getItems(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8090/cart/getItems/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String pay(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8110/payment/pay/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String checkoutComplete(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8200/ticketPortalManager/checkoutComplete/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String issueTickets(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8400/ticketingManager/issueTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }
}
