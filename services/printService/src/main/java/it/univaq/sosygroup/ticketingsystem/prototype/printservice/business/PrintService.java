package it.univaq.sosygroup.ticketingsystem.prototype.printservice.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class PrintService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated PrintService instance #" + instanceNumber);
    }

    public void printTickets(String instanceId) {
        System.out.printf("[Choreography instance %s] Print Tickets on Print Service instance %s%n", instanceId, instanceNumber);
    }
}
