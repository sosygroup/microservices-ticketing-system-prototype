package it.univaq.sosygroup.ticketingsystem.prototype.eventCatalog.business;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EventCatalogService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated EventCatalog instance #" + instanceNumber);
    }

    public void getEvents(String instanceId) {
        System.out.println("Called GetEvents Operation on EventCatalog instance #" + instanceNumber);
    }

    public void getEventInfo(String instanceId) {
        System.out.println("Called GetEventInfo Operation on EventCatalog instance #" + instanceNumber);
    }

    public void updateAvailability(String instanceId) {
        System.out.println("Called UpdateAvailability Operation on EventCatalog instance #" + instanceNumber);
    }
}
