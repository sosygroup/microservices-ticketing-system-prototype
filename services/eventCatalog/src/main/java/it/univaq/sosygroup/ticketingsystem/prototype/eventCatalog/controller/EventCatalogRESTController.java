package it.univaq.sosygroup.ticketingsystem.prototype.eventCatalog.controller;


import it.univaq.sosygroup.ticketingsystem.prototype.eventCatalog.business.EventCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventCatalogRESTController {

    private final EventCatalogService eventCatalogService;

    public EventCatalogRESTController(EventCatalogService eventCatalogService) {
        this.eventCatalogService = eventCatalogService;
    }

    @GetMapping("/getEvents/{instanceId}")
    public ResponseEntity<String> getEvents(@PathVariable String instanceId) {
        String response = "EventCatalog instance: " + instanceId + " - Operation: GetEvents" ;
        eventCatalogService.getEvents(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getEventInfo/{instanceId}")
    public ResponseEntity<String> getEventInfo(@PathVariable String instanceId){
        String response = "EventCatalog instance: " + instanceId + " - Operation: GetEventInfo" ;
        eventCatalogService.getEventInfo(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/updateAvailability/{instanceId}")
    public ResponseEntity<String> updateAvailability(@PathVariable String instanceId){
        String response = "EventCatalog instance: " + instanceId + " - Operation: UpdateAvailability" ;
        eventCatalogService.updateAvailability(instanceId);
        return ResponseEntity.ok(response);
    }
}
