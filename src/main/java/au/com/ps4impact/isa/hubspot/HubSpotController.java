package au.com.ps4impact.isa.hubspot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class HubSpotController {

    @Autowired
    private HubSpotContactService contactService;

    @Autowired
    private HubSpotDealService dealService;

    // Endpoint to get contacts from HubSpot API
    @GetMapping("/contacts")
    public Mono<List<Contact>> getContacts() {
        return contactService.getContacts();  // Call the service and return the result
    }

    @GetMapping("/deals")
    public Mono<String> getDeals() {
        return dealService.getDeals();
    }

}
