package it.univaq.sosygroup.ticketingsystem.prototype.checkoutmanager.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CheckoutManagerService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Ticketing Manager instance #" + instanceNumber);
    }

    public void issueTickets(String instanceId) {
        System.out.printf("[Choreography instance %s] Issue Tickets on Ticketing Manager instance %s%n", instanceId, instanceNumber);

        // TODO Implement call towards CD Ticketing Manager: create tickets, print tickets, prepare tickets shipping, ticket issue completed
    }
}
