package it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdticketportalmanager.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdticketportalmanager.business.CDTicketPortalManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CDTicketPortalManagerRESTController {

    private final CDTicketPortalManagerService cdTicketPortalManagerService;

    public CDTicketPortalManagerRESTController(CDTicketPortalManagerService cdTicketPortalManagerService) {
        this.cdTicketPortalManagerService = cdTicketPortalManagerService;
    }

    @GetMapping("/checkBanishment/{instanceId}")
    public ResponseEntity<?> checkBanishment(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.checkBanishment(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/createTempReservation/{instanceId}")
    public ResponseEntity<?> createTempReservation(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.createTempReservation(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/addTickets/{instanceId}")
    public ResponseEntity<?> addTickets(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.addTickets(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/ticketsReserved/{instanceId}")
    public ResponseEntity<?> ticketsReserved(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.ticketsReserved(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/releaseReservation/{instanceId}")
    public ResponseEntity<?> releaseReservation(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.releaseReservation(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/emptyCart/{instanceId}")
    public ResponseEntity<?> emptyCart(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.emptyCart(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/processCheckout/{instanceId}")
    public ResponseEntity<?> processCheckout(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.processCheckout(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/confirmReservation/{instanceId}")
    public ResponseEntity<?> confirmReservation(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.confirmReservation(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/updateAvailability/{instanceId}")
    public ResponseEntity<?> updateAvailability(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.updateAvailability(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/returnTicketsAndShippingInfo/{instanceId}")
    public ResponseEntity<?> returnTicketsAndShippingInfo(@PathVariable String instanceId) {
        String response = cdTicketPortalManagerService.returnTicketsAndShippingInfo(instanceId);

        return ResponseEntity.ok(response);
    }
}
