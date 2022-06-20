package it.univaq.sosygroup.ticketingsystem.prototype.cart.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CartService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Cart instance #" + instanceNumber);
    }

    public void addTickets(String instanceId) {
        System.out.printf("[Choreography instance %s] Add Tickets to User Cart on Cart instance %s%n", instanceId, instanceNumber);
    }

    public void getItems(String instanceId) {
        System.out.printf("[Choreography instance %s] Get Items on Cart instance %s%n", instanceId, instanceNumber);
    }

    public void emptyCart(String instanceId) {
        System.out.printf("[Choreography instance %s] Empty Cart on Cart instance %s%n", instanceId, instanceNumber);
    }
}
