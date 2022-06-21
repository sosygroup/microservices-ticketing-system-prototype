package it.univaq.sosygroup.ticketingsystem.prototype.loadbalancers.lbticketportalmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class LBTicketPortalManagerRESTController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public LBTicketPortalManagerRESTController(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    @GetMapping("/selectTickets/{instanceId}")
    public ResponseEntity<String> selectTickets(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketportalmanager/selectTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    @GetMapping("/requestCheckout/{instanceId}")
    public ResponseEntity<String> requestCheckout(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketportalmanager/requestCheckout/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    @GetMapping("/checkoutComplete/{instanceId}")
    public ResponseEntity<String> checkoutComplete(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketportalmanager/checkoutComplete/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    @GetMapping("/ticketIssueCompleted/{instanceId}")
    public ResponseEntity<String> ticketIssueCompleted(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketportalmanager/ticketIssueCompleted/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }
}
