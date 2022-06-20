package it.univaq.sosygroup.ticketingsystem.prototype.shipping.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.shipping.business.ShippingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingRESTController {

    private final ShippingService shippingService;

    public ShippingRESTController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/prepareTicketsShipping/{instanceId}")
    public ResponseEntity<String> prepareTicketsShipping(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Shipping - Operation: Prepare Tickets Shipping", instanceId);
        shippingService.prepareTicketsShipping(instanceId);
        return ResponseEntity.ok(response);
    }

}
