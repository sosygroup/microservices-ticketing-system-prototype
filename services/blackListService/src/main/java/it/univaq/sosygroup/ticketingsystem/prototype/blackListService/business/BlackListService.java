package it.univaq.sosygroup.ticketingsystem.prototype.blackListService.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class BlackListService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated BlackListService instance #" + instanceNumber);
    }

    public void checkBanishment(String instanceId) {
        System.out.println("Called CheckBanishment Operation on BlackListService instance #" + instanceNumber);
    }
}
