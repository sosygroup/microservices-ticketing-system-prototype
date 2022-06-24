package it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdticketportalmanager.business;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CDTicketPortalManagerService {

    private final WebClient.Builder webClientBuilder;

    public CDTicketPortalManagerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String checkBanishment(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8080/blacklistService/checkBanishment/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String createTempReservation(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8130/reservationService/createTempReservation/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String addTickets(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8090/cart/addTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String ticketsReserved(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8888/customer/ticketsReserved/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String releaseReservation(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8130/reservationService/createTempReservation/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String emptyCart(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8090/cart/emptyCart/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String processCheckout(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8300/checkoutManager/processCheckout/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String confirmReservation(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8130/reservationService/confirmReservation/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String updateAvailability(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8100/eventCatalog/updateAvailability/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

    public String returnTicketsAndShippingInfo(String instanceId) {
        ResponseEntity<String> response = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8888/customer/returnTicketsAndShippingInfo/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        return response != null ? response.getBody() : null;
    }

}
