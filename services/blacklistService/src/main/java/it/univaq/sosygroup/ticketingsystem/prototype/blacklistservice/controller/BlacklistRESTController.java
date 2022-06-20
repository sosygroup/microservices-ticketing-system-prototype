package it.univaq.sosygroup.ticketingsystem.prototype.blacklistservice.controller;

import it.univaq.sosygroup.ticketingsystem.prototype.blacklistservice.business.BlacklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlacklistRESTController {

    private final BlacklistService blackListService;

    public BlacklistRESTController(BlacklistService blackListService) {
        this.blackListService = blackListService;
    }

    @GetMapping("/checkBanishment/{instanceId}")
    public ResponseEntity<String> checkBanishment(@PathVariable String instanceId) {
        String response = String.format("[Choreography instance %s] BlacklistService - Operation: Check Banishment", instanceId);
        blackListService.checkBanishment(instanceId);
        return ResponseEntity.ok(response);
    }

}
