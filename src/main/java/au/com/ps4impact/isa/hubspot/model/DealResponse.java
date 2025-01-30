package au.com.ps4impact.isa.hubspot.model;

import lombok.Data;

import java.util.List;

@Data
public class DealResponse {
    private List<Deal> results;
}
