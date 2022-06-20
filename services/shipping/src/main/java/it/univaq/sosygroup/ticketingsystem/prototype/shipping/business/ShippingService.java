package it.univaq.sosygroup.ticketingsystem.prototype.shipping.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ShippingService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Shipping instance #" + instanceNumber);
    }

    public void prepareTicketsShipping(String instanceId) {
        System.out.printf("[Choreography instance %s] Prepare Tickets Shipping on Shipping instance %s%n", instanceId, instanceNumber);
    }
}
