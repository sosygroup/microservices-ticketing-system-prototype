package it.univaq.sosygroup.ticketingsystem.prototype.loadbalancers.lbticketingmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class LBTicketingManagerRESTController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public LBTicketingManagerRESTController(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    @GetMapping("/issueTickets/{instanceId}")
    public ResponseEntity<String> issuetickets(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketingmanager/issueTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }
}
