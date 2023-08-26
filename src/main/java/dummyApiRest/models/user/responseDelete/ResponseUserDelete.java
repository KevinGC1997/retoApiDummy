package dummyApiRest.models.user.responseDelete;

import com.fasterxml.jackson.annotation.JsonProperty;
import dummyApiRest.models.user.responseUser.DataPost;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDelete {
    @JsonProperty("status")
    public String status;

    @JsonProperty("data")
    public String data;

    @JsonProperty("message")
    public String message;
}
