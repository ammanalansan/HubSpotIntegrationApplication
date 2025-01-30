package au.com.ps4impact.isa.hubspot;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Contact {

    private String id;
    private Properties properties;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private boolean archived;

    @Data
    public static class Properties {
        private ZonedDateTime createDate;
        private String email;
        private String firstname;
        private String lastname;
        private String hsObjectId;
        private ZonedDateTime lastModifiedDate;
    }
}
