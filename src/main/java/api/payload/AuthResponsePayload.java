package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthResponsePayload {
    @JsonProperty
    private String token;
}
