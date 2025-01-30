package au.com.ps4impact.isa.hubspot;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class HubSpotContactService {

    @Value("${hubspot.api.url}")
    private String apiUrl;

    @Value("${hubspot.api.token}")
    private String apiToken;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient = webClientBuilder.baseUrl(apiUrl).build();
    }

    /**
     * Method to call the HubSpot API and fetch contacts
      * @return
     */
    public Mono<List<Contact>> getContacts() {
        return webClient.get()
                .uri("/contacts")
                .header("Authorization", "Bearer " + apiToken)  // Add Bearer token for authentication
                .retrieve()
                .bodyToFlux(Contact.class)
                .collectList();  // Return response body as a String (JSON)
    }
}
