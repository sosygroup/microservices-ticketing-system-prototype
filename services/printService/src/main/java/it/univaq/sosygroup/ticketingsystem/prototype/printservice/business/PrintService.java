package it.univaq.sosygroup.ticketingsystem.prototype.printservice.business;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PrintService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated PrintService instance #" + instanceNumber);
    }

    public void printTickets(String instanceId) {
        System.out.printf("[Choreography instance %s] Print Tickets on Print Service instance %s%n", instanceId, instanceNumber);

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
