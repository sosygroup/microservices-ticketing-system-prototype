package it.univaq.sosygroup.ticketingsystem.prototype.blacklistservice.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class BlacklistService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated BlacklistService instance " + instanceNumber);
    }

    public void checkBanishment(String instanceId) {
        System.out.printf("[Choreography instance %s] Check Banishment on BlacklistService instance %s%n", instanceId, instanceNumber);
    }
}
