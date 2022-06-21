package it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdcustomer.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.cds.unbalanced.cdcustomer.business.CDCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CDCustomerRESTController {

    private final CDCustomerService cdCustomerService;

    public CDCustomerRESTController(CDCustomerService cdCustomerService) {
        this.cdCustomerService = cdCustomerService;
    }

    @GetMapping("/getEvents/{instanceId}")
    public ResponseEntity<?> getEvents(@PathVariable String instanceId) {
        String response = cdCustomerService.getEvents(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getEventInfo/{instanceId}")
    public ResponseEntity<?> getEventInfo(@PathVariable String instanceId) {
        String response = cdCustomerService.getEventInfo(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/selectTickets/{instanceId}")
    public ResponseEntity<?> selectTickets(@PathVariable String instanceId) {
        String response = cdCustomerService.selectTickets(instanceId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/requestCheckout/{instanceId}")
    public ResponseEntity<?> requestCheckout(@PathVariable String instanceId) {
        String response = cdCustomerService.requestCheckout(instanceId);

        return ResponseEntity.ok(response);
    }
}
