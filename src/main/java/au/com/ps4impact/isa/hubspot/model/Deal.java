package au.com.ps4impact.isa.hubspot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Deal {
    private String id;

    @JsonProperty("properties")
    private DealProperties properties;

    @Data
    public static class DealProperties {
        private String dealname;
        private String amount;
        // add more
    }
}

