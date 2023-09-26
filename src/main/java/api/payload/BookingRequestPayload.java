package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingRequestPayload {

    @JsonProperty("firstname")
    public String firstName;
    @JsonProperty("lastname")
    public String lastName;
    @JsonProperty("totalprice")
    public int totalPrice;
    @JsonProperty("depositpaid")
    public boolean depositPaid;
    @JsonProperty("bookingdates")
    public BookingDates bookingDates;
    @JsonProperty("additionalneeds")
    public String additionalNeeds;
}
