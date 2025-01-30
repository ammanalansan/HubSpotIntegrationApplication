package au.com.ps4impact.isa.hubspot;

import au.com.ps4impact.isa.hubspot.model.Contact;
import au.com.ps4impact.isa.hubspot.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HubSpotController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private DealService dealService;

    // Endpoint to get contacts from HubSpot API
    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return contactService.getContacts();  // Call the service and return the result
    }

    @GetMapping("/deals")
    public List<Deal> getDeals() {
        return dealService.getDeals();
    }

    @GetMapping("/first")
    public String getFirstDeal() {
        Deal deal = getDeals().getFirst();
        return deal.getProperties().getDealname();
    }

    @GetMapping("/firstContact")
    public String getFirstContact() {
        Contact contact = getContacts().getFirst();
        return contact.getProperties().getEmail();
    }

}
