package dummyApiRest.models.user.responseUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserPost {

    @JsonProperty("status")
    public String status;

    @JsonProperty("data")
    public DataPost data;

    @JsonProperty("message")
    public String message;
}
