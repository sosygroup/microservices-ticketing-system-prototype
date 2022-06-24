package it.univaq.sosygroup.ticketingsystem.prototype.ticketportalmanager.business;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class TicketPortalManagerService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Ticket Portal Manager instance #" + instanceNumber);
    }

    private final WebClient.Builder webClientBuilder;

    public TicketPortalManagerService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public void selectTickets(String instanceId) {
        System.out.printf("[Choreography instance %s] Select Tickets on Ticket Portal Manager instance %s%n", instanceId, instanceNumber);

        System.out.println("Performed calls:");

        ResponseEntity<String> checkBanishmentResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8250/cdTicketPortalManager/checkBanishment/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(checkBanishmentResponse);

        // If not allowed, notify error!

        // Parallelize:

        Tuple2<String, String> reservationAndCartResponses = Mono.zip(
                webClientBuilder.build().get()
                        .uri(String.format("http://localhost:8250/cdTicketPortalManager/createTempReservation/%s", instanceId))
                        .retrieve().bodyToMono(String.class),
                webClientBuilder.build().get()
                        .uri(String.format("http://localhost:8250/cdTicketPortalManager/addTickets/%s", instanceId))
                        .retrieve().bodyToMono(String.class)
        ).block();

        System.out.println(reservationAndCartResponses.get(0));
        System.out.println(reservationAndCartResponses.get(1));

        // End parallel

        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8250/cdTicketPortalManager/ticketsReserved/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println("Called back Customer service");

        System.out.printf("[Choreography instance %s] Ended Issue Tickets", instanceId);
    }

    public void requestCheckout(String instanceId) {
        System.out.printf("[Choreography instance %s] Request Checkout on Ticket Portal Manager instance %s%n", instanceId, instanceNumber);

        System.out.println("Performed calls:");

        ResponseEntity<String> processCheckoutResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8250/cdTicketPortalManager/processCheckout/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(processCheckoutResponse);

        System.out.printf("[Choreography instance %s] Ended Request Checkout", instanceId);
    }

    public void checkoutComplete(String instanceId) {
        System.out.printf("[Choreography instance %s] Checkout Complete on Ticket Portal Manager instance %s%n", instanceId, instanceNumber);

        System.out.println("Performed calls:");

        ResponseEntity<String> confirmReservationResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8250/cdTicketPortalManager/confirmReservation/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(confirmReservationResponse);

        ResponseEntity<String> updateAvailabilityResponse = webClientBuilder.build().get()
                .uri(String.format("http://localhost:8250/cdTicketPortalManager/updateAvailability/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println(updateAvailabilityResponse);

        System.out.printf("[Choreography instance %s] Ended Checkout Complete", instanceId);
    }

    public void ticketIssueCompleted(String instanceId) {
        System.out.printf("[Choreography instance %s] Ticket Issue Completed on Ticket Portal Manager instance %s%n", instanceId, instanceNumber);

        System.out.println("Performed calls:");
        webClientBuilder.build().get()
                .uri(String.format("http://localhost:8250/cdTicketPortalManager/returnTicketsAndShippingInfo/%s", instanceId))
                .retrieve().toEntity(String.class).block();
        System.out.println("Called back Customer service");

        System.out.println("[Choreography instance %s] Ended Ticket Issue Completed");
    }
}
