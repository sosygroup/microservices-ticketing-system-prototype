package it.univaq.sosygroup.ticketingsystem.prototype.reservationservice.business;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class ReservationService {

    static int instanceNumber;

    static {
        instanceNumber = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Instantiated Reservation Service instance #" + instanceNumber);
    }

    public void createTempReservation(String instanceId) {
        System.out.printf("[Choreography instance %s] Create Temp Reservation on Reservation Service instance %s%n", instanceId, instanceNumber);
    }

    public void confirmReservation(String instanceId) {
        System.out.printf("[Choreography instance %s] Confirm Reservation on Reservation Service instance %s%n", instanceId, instanceNumber);
    }

    public void releaseReservation(String instanceId) {
        System.out.printf("[Choreography instance %s] Release Reservation on Reservation Service instance %s%n", instanceId, instanceNumber);
    }
}
