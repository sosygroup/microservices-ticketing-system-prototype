package it.univaq.sosygroup.ticketingsystem.prototype.eventcatalog.business;

import org.springframework.stereotype.Service;

import java.util.Random;
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

        performSomeDummyLogics(20);
    }

    public void getEventInfo(String instanceId) {
        System.out.printf("[Choreography instance %s] Get Event Info on Event Catalog instance %s%n", instanceId, instanceNumber);
        performSomeDummyLogics(20);
    }

    public void updateAvailability(String instanceId) {
        System.out.printf("[Choreography instance %s] Update Availability on Event Catalog instance %s%n", instanceId, instanceNumber);
        performSomeDummyLogics(30);
    }

    private void performSomeDummyLogics(int weight) {
        // Create a random array and sort with bubble sort

        Random rd = new Random();
        int[] arr = new int[weight];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }

        for (int i= 0 ; i < arr.length-1; ++i){
            for(int j = 0 ; j <arr.length-i-1; ++j){
                if(arr[j+1] < arr[j]){
                    int swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;
                }
            }
        }
    }
}
