package it.univaq.sosygroup.ticketingsystem.prototype.eventcatalog.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class EventCatalogService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Event Catalog instance #" + instanceNumber);
    }

    public void getEvents(String instanceId) {
        System.out.printf("[Choreography instance %s] Get Events on Event Catalog instance %s%n", instanceId, instanceNumber);
    }

    public void getEventInfo(String instanceId) {
        System.out.printf("[Choreography instance %s] Get Event Info on Event Catalog instance %s%n", instanceId, instanceNumber);
    }

    public void updateAvailability(String instanceId) {
        System.out.printf("[Choreography instance %s] Update Availability on Event Catalog instance %s%n", instanceId, instanceNumber);
    }
}
