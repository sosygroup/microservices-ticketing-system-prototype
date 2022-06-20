package it.univaq.sosygroup.ticketingsystem.prototype.cart.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.cart.business.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRESTController {

    private final CartService cartService;

    public CartRESTController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/addTickets/{instanceId}")
    public ResponseEntity<String> addTickets(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Cart - Operation: Add Tickets to User Cart", instanceId);
        cartService.addTickets(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getItems/{instanceId}")
    public ResponseEntity<String> getItems(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Cart - Operation: Get Cart Items", instanceId);
        cartService.getItems(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/emptyCart/{instanceId}")
    public ResponseEntity<String> emptyCart(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] Cart - Operation: Empty Cart", instanceId);
        cartService.emptyCart(instanceId);
        return ResponseEntity.ok(response);
    }

}
