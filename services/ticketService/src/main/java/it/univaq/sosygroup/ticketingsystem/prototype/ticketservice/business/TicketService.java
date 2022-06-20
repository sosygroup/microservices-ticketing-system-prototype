package it.univaq.sosygroup.ticketingsystem.prototype.ticketservice.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class TicketService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Ticket Service instance #" + instanceNumber);
    }

    public void createTickets(String instanceId) {
        System.out.printf("[Choreography instance %s] Create Tickets on Ticket Service instance %s%n", instanceId, instanceNumber);
    }
}
