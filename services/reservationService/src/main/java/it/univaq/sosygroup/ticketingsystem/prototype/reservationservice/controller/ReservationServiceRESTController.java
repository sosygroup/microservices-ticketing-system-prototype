package it.univaq.sosygroup.ticketingsystem.prototype.reservationservice.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.reservationservice.business.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationServiceRESTController {

    private final ReservationService reservationService;

    public ReservationServiceRESTController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/createTempReservation/{instanceId}")
    public ResponseEntity<String> create(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Reservation Service - Operation: Create Temp Reservation", instanceId);
        reservationService.createTempReservation(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/confirmReservation/{instanceId}")
    public ResponseEntity<String> confirm(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Reservation Service - Operation: Confirm Reservation", instanceId);
        reservationService.confirmReservation(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/releaseReservation/{instanceId}")
    public ResponseEntity<String> release(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Reservation Service - Operation: Release Reservation", instanceId);
        reservationService.releaseReservation(instanceId);
        return ResponseEntity.ok(response);
    }
}
