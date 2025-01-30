package au.com.ps4impact.isa.hubspot;

import au.com.ps4impact.isa.hubspot.model.Deal;
import au.com.ps4impact.isa.hubspot.model.DealResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Slf4j
@Service
public class DealService {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private RestTemplate restTemplate;


    /**
     * TODO: Need to update the OAuth configuration and use here
     *
     * @return
     */
    public List<Deal> getDeals() {
        String url = UriComponentsBuilder.fromHttpUrl(appProperties.getHubspotUri())
                .path("/deals")
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + appProperties.getToken());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Perform GET request to fetch the deals with OAuth authentication
        DealResponse dealsResponse = restTemplate.exchange(url, HttpMethod.GET, entity, DealResponse.class).getBody();

        // Return the list of deals
        return dealsResponse != null ? dealsResponse.getResults() : null;
    }
}
