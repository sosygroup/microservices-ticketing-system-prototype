package it.univaq.sosygroup.ticketingsystem.prototype.eventcatalog.controller;


import it.univaq.sosygroup.ticketingsystem.prototype.eventcatalog.business.EventCatalogService;
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
        String response = String.format("[Choreography instance %s] Event Catalog - Operation: Get Events", instanceId);
        eventCatalogService.getEvents(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getEventInfo/{instanceId}")
    public ResponseEntity<String> getEventInfo(@PathVariable String instanceId){
        String response = String.format("[Choreography instance %s] Event Catalog - Operation: Get Event Info", instanceId);
        eventCatalogService.getEventInfo(instanceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/updateAvailability/{instanceId}")
    public ResponseEntity<String> updateAvailability(@PathVariable String instanceId){
        String response = String.format("[Choreography instance %s] Event Catalog - Operation: Update Availability", instanceId);
        eventCatalogService.updateAvailability(instanceId);
        return ResponseEntity.ok(response);
    }
}
