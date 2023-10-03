package api.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDates {

    @JsonProperty("checkin")
    public String checkin;
    @JsonProperty("checkout")
    public String checkout;

}
