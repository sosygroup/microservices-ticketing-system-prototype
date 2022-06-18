package it.univaq.sosygroup.ticketingsystem.prototype.payment.business;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PaymentService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated PaymentService instance #" + instanceNumber);
    }

    public void pay(String instanceId) {

        System.out.println("Called instance #" + instanceNumber);
    }
}
