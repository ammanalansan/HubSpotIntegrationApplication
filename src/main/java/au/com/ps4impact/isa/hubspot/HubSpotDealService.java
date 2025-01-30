package au.com.ps4impact.isa.hubspot;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class HubSpotDealService {

    @Value("${hubspot.api.url}")
    private String apiUrl;

    @Value("${hubspot.api.token}")
    private String apiToken;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private WebClient webClient;

    @PostConstruct
    public void init() {
        this.webClient = webClientBuilder.baseUrl(apiUrl + "/deals").build();
    }

    /**
     * Method to call the HubSpot API and fetch contacts
      * @return
     */
    public Mono<String> getDeals() {
        return webClient.get()
                .uri("")
                .header("Authorization", "Bearer " + apiToken)  // Add Bearer token for authentication
                .retrieve()
                .bodyToMono(String.class);  // Return response body as a String (JSON)
    }
}
