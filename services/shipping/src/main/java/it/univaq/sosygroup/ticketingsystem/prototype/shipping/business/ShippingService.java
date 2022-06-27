package it.univaq.sosygroup.ticketingsystem.prototype.shipping.business;

import org.springframework.stereotype.Service;

import java.util.Random;
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

        performSomeDummyLogics(20);
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
