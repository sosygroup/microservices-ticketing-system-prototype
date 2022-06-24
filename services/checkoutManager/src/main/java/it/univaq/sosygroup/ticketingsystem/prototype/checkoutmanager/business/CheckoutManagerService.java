package it.univaq.sosygroup.ticketingsystem.prototype.checkoutmanager.business;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CheckoutManagerService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Checkout Manager instance #" + instanceNumber);
    }

    private final WebClient.Builder webClientBuilder;

    public CheckoutManagerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String processCheckout(String instanceId) {
        System.out.printf("[Choreography instance %s] Process Checkout on Checkout Manager instance %s%n", instanceId, instanceNumber);
        System.out.println("Performed calls:");

        ResponseEntity<String> cartResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8350/cdCheckoutManager/getItems/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(cartResponse);

        ResponseEntity<String> payResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8350/cdCheckoutManager/pay/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(payResponse);

        ResponseEntity<String> checkoutCompleteResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8350/cdCheckoutManager/checkoutComplete/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(checkoutCompleteResponse);

        ResponseEntity<String> issueTicketsResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8350/cdCheckoutManager/issueTickets/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(issueTicketsResponse);
        System.out.printf("[Choreography instance %s] Ended Process Checkout", instanceId);

        return String.format("[Choreography instance %s] Process checkout on Checkout Manager instance %s%n", instanceId, instanceNumber);
    }
}
