package it.univaq.sosygroup.ticketingsystem.prototype.ticketportalmanager.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class TicketPortalManagerService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Ticket Portal Manager instance #" + instanceNumber);
    }

    public void prepareTicketsShipping(String instanceId) {
        System.out.printf("[Choreography instance %s] Select Tickets on Ticket Portal Manager instance %s%n", instanceId, instanceNumber);

        // TODO Implement call towards CD Ticket Portal Manager: check banishment, create temp reservation, add tickets to user cart, tickets temp reserved
    }

    public void requestCheckout(String instanceId) {
        System.out.printf("[Choreography instance %s] Request Checkout on Ticket Portal Manager instance %s%n", instanceId, instanceNumber);

        // TODO Implement call towards CD Ticket Portal Manager: process checkout
    }

    public void checkoutComplete(String instanceId) {
        System.out.printf("[Choreography instance %s] Checkout Complete on Ticket Portal Manager instance %s%n", instanceId, instanceNumber);

        // TODO Implement call towards CD Ticket Portal Manager: confirm reservation, update availability
    }

    public void ticketIssueCompleted(String instanceId) {
        System.out.printf("[Choreography instance %s] Ticket Issue Completed on Ticket Portal Manager instance %s%n", instanceId, instanceNumber);

        // TODO Implement call towards CD Ticket Portal Manager: return tickets and shipping info
    }
}
