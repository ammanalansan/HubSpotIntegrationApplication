package au.com.ps4impact.isa.hubspot;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.kafka")
public class AppProperties {

  @NotBlank
  private String hubspotUri;

    /**
     * TODO: Temporary add this here, while solving the OAuth configuration
     * Currently token is not rotating
     */
  @NotBlank
  private String token;

  @NestedConfigurationProperty
  private Topics topics;

  /**
   * The application configuration for the Kakfa topics it connects to.
   */
  @Data
  public static class Topics {

    /**
     * Input topic containing new project events
     */
    @NotBlank
    private String input;

    /**
     * Output topic to which to publish enriched new project messages
     */
    @NotBlank
    private String output;
  }

}
