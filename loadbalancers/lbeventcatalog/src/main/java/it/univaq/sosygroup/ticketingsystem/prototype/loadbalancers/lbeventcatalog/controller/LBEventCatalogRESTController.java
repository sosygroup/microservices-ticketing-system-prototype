package it.univaq.sosygroup.ticketingsystem.prototype.loadbalancers.lbeventcatalog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class LBEventCatalogRESTController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public LBEventCatalogRESTController(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    @GetMapping("/getEvents/{instanceId}")
    public ResponseEntity<String> getEvents(@PathVariable String instanceId) {
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://eventcatalog/getEvents/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    @GetMapping("/getEventInfo/{instanceId}")
    public ResponseEntity<String> getEventInfo(@PathVariable String instanceId){
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://eventcatalog/getEventInfo/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }

    @GetMapping("/updateAvailability/{instanceId}")
    public ResponseEntity<String> updateAvailability(@PathVariable String instanceId){
        return loadBalancedWebClientBuilder.build().get().uri(String.format("http://eventcatalog/updateAvailability/%s", instanceId))
                .retrieve().toEntity(String.class).block();
    }
}
