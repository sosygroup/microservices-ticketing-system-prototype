package it.univaq.sosygroup.ticketingsystem.prototype.cart.business;

import org.springframework.stereotype.Service;

import java.util.Random;
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
        performSomeDummyLogics(30);
    }

    public void getItems(String instanceId) {
        System.out.printf("[Choreography instance %s] Get Items on Cart instance %s%n", instanceId, instanceNumber);
        performSomeDummyLogics(30);
    }

    public void emptyCart(String instanceId) {
        System.out.printf("[Choreography instance %s] Empty Cart on Cart instance %s%n", instanceId, instanceNumber);
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
