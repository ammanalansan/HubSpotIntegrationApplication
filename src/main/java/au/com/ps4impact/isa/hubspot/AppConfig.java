package au.com.ps4impact.isa.hubspot;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class AppConfig {

    // Define WebClient as a Spring Bean to inject it into services
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
