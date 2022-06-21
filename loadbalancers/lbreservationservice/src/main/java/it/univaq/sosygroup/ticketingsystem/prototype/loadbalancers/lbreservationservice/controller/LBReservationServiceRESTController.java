package it.univaq.sosygroup.ticketingsystem.prototype.loadbalancers.lbreservationservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class LBReservationServiceRESTController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public LBReservationServiceRESTController(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    @GetMapping("/createTempReservation/{instanceId}")
    public ResponseEntity<String> create(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://reservationservice/createTempReservation/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    @GetMapping("/confirmReservation/{instanceId}")
    public ResponseEntity<String> confirm(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://reservationservice/confirmReservation/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    @GetMapping("/releaseReservation/{instanceId}")
    public ResponseEntity<String> release(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://reservationservice/releaseReservation/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }
}
