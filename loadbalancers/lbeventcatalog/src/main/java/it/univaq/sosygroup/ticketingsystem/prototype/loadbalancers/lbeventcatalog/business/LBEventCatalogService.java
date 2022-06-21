package it.univaq.sosygroup.ticketingsystem.prototype.loadbalancers.lbeventcatalog.business;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class LBEventCatalogService {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public LBEventCatalogService(WebClient.Builder webClientBuilder) {
        this.loadBalancedWebClientBuilder = webClientBuilder;
    }

    public void createTickets(String instanceId) {

        loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketing/createTickets/%s", instanceId))
                .retrieve().toEntity(String.class).subscribe(System.out::println);
    }

    public void printTickets(String instanceId) {

        loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketing/printTickets/%s", instanceId))
                .retrieve().toEntity(String.class).subscribe(System.out::println);
    }

    public void prepareTicketShipping(String instanceId) {

        loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketing/prepareTicketShipping/%s", instanceId))
                .retrieve().toEntity(String.class).subscribe(System.out::println);
    }

    public void completeTicketIssue(String instanceId) {

        loadBalancedWebClientBuilder.build().get().uri(String.format("http://ticketing/completeTicketIssue/%s", instanceId))
                .retrieve().toEntity(String.class).subscribe(System.out::println);
    }
}
