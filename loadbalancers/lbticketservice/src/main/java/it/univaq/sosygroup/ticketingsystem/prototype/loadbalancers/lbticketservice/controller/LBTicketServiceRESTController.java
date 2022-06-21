package it.univaq.sosygroup.ticketingsystem.prototype.loadbalancers.lbticketservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class LBTicketServiceRESTController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public LBTicketServiceRESTController(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    @GetMapping("/createTickets/{instanceId}")
    public ResponseEntity<String> createTickets(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketservice/createTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }
}
