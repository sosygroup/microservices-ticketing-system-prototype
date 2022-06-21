package it.univaq.sosygroup.ticketingsystem.prototype.loadbalancers.lbeventcatalog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class LBCheckoutManagerRESTController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public LBCheckoutManagerRESTController(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    @GetMapping("/processCheckout/{instanceId}")
    public ResponseEntity<String> processCheckout(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://checkoutmanager/processCheckout/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }
}
