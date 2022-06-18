package it.univaq.sosygroup.ticketingsystem.prototype.blackListService.controller;

;
import it.univaq.sosygroup.ticketingsystem.prototype.blackListService.business.BlackListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlackListRESTController {

    private final BlackListService blackListService;

    public BlackListRESTController(BlackListService blackListService) {
        this.blackListService = blackListService;
    }

    @GetMapping("/checkBanishment/{instanceId}")
    public ResponseEntity<String> checkBanishment(@PathVariable String instanceId) {
        String response = "BlackListService instance: " + instanceId + " - Operation: CheckBanishment" ;
        blackListService.checkBanishment(instanceId);
        return ResponseEntity.ok(response);
    }

}
